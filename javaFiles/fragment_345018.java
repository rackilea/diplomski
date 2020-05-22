import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ConfigurableFontTable extends Application {

    private StringProperty fontFamily = new SimpleStringProperty(Font.getDefault().getFamily());
    private ObjectProperty<FontWeight> fontWeight = new SimpleObjectProperty<>(FontWeight.NORMAL);
    private BooleanProperty italic = new SimpleBooleanProperty();
    private IntegerProperty fontSize = new SimpleIntegerProperty((int)Font.getDefault().getSize());

    private ObjectProperty<Color> fontFill = new SimpleObjectProperty<>(Color.BLACK);

    private StringProperty style = new SimpleStringProperty();

    @Override
    public void start(Stage primaryStage) {
        style.bind(Bindings.createStringBinding(() -> String.format(
                "-fx-font-family: %s;\n"
                + "-fx-font-weight: %d;\n"
                + "-fx-font-style: %s;\n"
                + "-fx-font-size: %d;\n"
                + "-fx-text-background-color: rgba(%d, %d, %d, %f);\n",
                fontFamily.get(),
                fontWeight.get().getWeight(),
                italic.get()?"italic":"normal",
                fontSize.get(),
                (int)(255 * fontFill.get().getRed()),
                (int)(255 * fontFill.get().getGreen()),
                (int)(255 * fontFill.get().getBlue()),
                fontFill.get().getOpacity()
            ),
            fontFamily,
            fontWeight,
            italic,
            fontSize,
            fontFill
        ));

        TableView<Person> table = new TableView<>();
        table.setRowFactory(tv -> {
            TableRow<Person> row = new TableRow<>();
            row.styleProperty().bind(style);
            return row ;
        });

        table.getColumns().add(column("First Name", Person::firstNameProperty));
        table.getColumns().add(column("Last Name", Person::lastNameProperty));
        table.getColumns().add(column("Email", Person::emailProperty));

        table.getItems().addAll(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")
        );

        Button changeStyleButton = new Button("Change style...");
        changeStyleButton.setOnAction(e -> showChangeStyleDialog(primaryStage));

        BorderPane root = new BorderPane(table, null, null, changeStyleButton, null);
        BorderPane.setAlignment(changeStyleButton, Pos.CENTER);
        BorderPane.setMargin(changeStyleButton, new Insets(10));

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void showChangeStyleDialog(Stage owner) {
        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(10));

        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHalignment(HPos.RIGHT);
        leftCol.setHgrow(Priority.NEVER);

        ColumnConstraints rightCol = new ColumnConstraints();

        root.getColumnConstraints().addAll(leftCol, rightCol);

        ComboBox<String> fontFamilyChoice = new ComboBox<>();
        fontFamilyChoice.getItems().addAll(Font.getFamilies());
        fontFamilyChoice.setValue(fontFamily.get());

        ComboBox<FontWeight> fontWeightChoice = new ComboBox<>();
        fontWeightChoice.getItems().addAll(FontWeight.values());
        fontWeightChoice.setValue(fontWeight.get());

        CheckBox italicCheckBox = new CheckBox("Italic");
        italicCheckBox.setSelected(italic.get());

        ComboBox<Integer> fontSizeChoice = new ComboBox<>();
        fontSizeChoice.getItems().addAll(4, 6, 8, 10, 12, 16, 20, 24, 32, 40, 48);
        fontSizeChoice.setValue(fontSize.get());

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(fontFill.get());

        root.addRow(0,  new Label("Font:"), fontFamilyChoice);
        root.addRow(1, new Label("Weight:"), fontWeightChoice);
        root.addRow(2, new Label("Size:"), fontSizeChoice);
        root.add(italicCheckBox, 1, 3);
        root.addRow(4, new Label("Text Color:"), colorPicker);

        Stage stage = new Stage();

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            fontFamily.set(fontFamilyChoice.getValue());
            fontWeight.set(fontWeightChoice.getValue());
            fontSize.set(fontSizeChoice.getValue());
            italic.set(italicCheckBox.isSelected());
            fontFill.set(colorPicker.getValue());
            stage.hide();
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> stage.hide());

        HBox buttons = new HBox(5, okButton, cancelButton);
        buttons.setAlignment(Pos.CENTER);
        root.add(buttons, 0, 5, 2, 1);

        stage.initOwner(owner);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private static <S,T> TableColumn<S,T> column(String title, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col ;
    }

    public class Person {
        private final StringProperty firstName = new SimpleStringProperty(this,"firstName");
        private final StringProperty lastName = new SimpleStringProperty(this, "lastName");
        private final StringProperty email = new SimpleStringProperty(this, "email");

        public Person(String firstName, String lastName, String email) {
            this.firstName.set(firstName);
            this.lastName.set(lastName);
            this.email.set(email);
        }

        public final StringProperty firstNameProperty() {
            return this.firstName;
        }

        public final String getFirstName() {
            return this.firstNameProperty().get();
        }

        public final void setFirstName(final String firstName) {
            this.firstNameProperty().set(firstName);
        }

        public final StringProperty lastNameProperty() {
            return this.lastName;
        }

        public final String getLastName() {
            return this.lastNameProperty().get();
        }

        public final void setLastName(final String lastName) {
            this.lastNameProperty().set(lastName);
        }

        public final StringProperty emailProperty() {
            return this.email;
        }

        public final String getEmail() {
            return this.emailProperty().get();
        }

        public final void setEmail(final String email) {
            this.emailProperty().set(email);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}