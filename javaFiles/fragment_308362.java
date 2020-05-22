import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener.Change;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShowHidePasswordExample extends Application {

    private static final Random RNG = new Random();

    @Override
    public void start(Stage primaryStage) {

        TableView<User> userTable = new TableView<>();

        // standard column stuff:
        TableColumn<User, String> userNameCol = new TableColumn<>("User Name");
        userNameCol.setCellValueFactory(cellData -> cellData.getValue().userNameProperty());

        TableColumn<User, String> passwordCol = new TableColumn<>("Password");
        passwordCol.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());

        // which passwords are shown:
        ObservableSet<User> usersWithShownPasswords = FXCollections.observableSet();

        // cell factory for password column. Cells must show either the
        // real or masked password, and may 
        // need to update if usersWithShownPasswords changes:

        passwordCol.setCellFactory(c -> {

            // plain old cell:
            TableCell<User, String> cell = new TableCell<>();

            // if the cell is reused for an item from a different row, update it:
            cell.indexProperty().addListener((obs, oldIndex, newIndex) -> 
                updateCell(usersWithShownPasswords, cell));

            // if the password changes, update:

            cell.itemProperty().addListener((obs, oldItem, newItem) -> 
                updateCell(usersWithShownPasswords, cell));

            // if the set of users with shown password changes, update the cell:
            usersWithShownPasswords.addListener((Change<? extends User> change) ->
                updateCell(usersWithShownPasswords, cell));

            return cell ;
        });

        // column with show/hide buttons:
        TableColumn<User, User> showHidePasswordCol = new TableColumn<>("Show/Hide password");

        // just use whole row (User) as data for cells in this column:
        showHidePasswordCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue()));

        // cell factory for toggle buttons:
        showHidePasswordCol.setCellFactory(c -> new TableCell<User, User>() {

            // create toggle button once for cell:
            private final ToggleButton button = new ToggleButton();

            // anonymous constructor:
            {
                // update toggle button state if usersWithShownPasswords changes:
                usersWithShownPasswords.addListener((Change<? extends User> change) -> {
                    button.setSelected(usersWithShownPasswords.contains(getItem()));
                });

                // update usersWithShownPasswords if toggle selection changes:
                button.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
                    if (isNowSelected) {
                        usersWithShownPasswords.add(getItem());
                    } else {
                        usersWithShownPasswords.remove(getItem());
                    }
                });

                // keep text "Show" or "Hide" appropriately:
                button.textProperty().bind(Bindings.when(button.selectedProperty()).then("Hide").otherwise("Show"));
                setAlignment(Pos.CENTER);
            }

            // Just update graphic as needed:

            @Override
            public void updateItem(User item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    button.setSelected(usersWithShownPasswords.contains(item));
                    setGraphic(button);
                }
            }
        });

        userTable.getColumns().addAll(Arrays.asList(userNameCol, passwordCol, showHidePasswordCol));

        userTable.getItems().addAll(createData());

        Scene scene = new Scene(new BorderPane(userTable), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void updateCell(ObservableSet<User> usersWithShownPasswords,
            TableCell<User, String> cell) {
        int index = cell.getIndex();
        TableView<User> table = cell.getTableView();
        if (index < 0 || index >= table.getItems().size()) {
            cell.setText("");
        } else {
            User user = table.getItems().get(index);
            if (usersWithShownPasswords.contains(user)) {
                cell.setText(user.getPassword()) ;
            } else {
                cell.setText(mask(user.getPassword()));
            }
        }
    }

    private String mask(String text) {
        char[] chars = new char[text.length()];
        Arrays.fill(chars, '*');
        return new String(chars);
    }

    private List<User> createData() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new User("User "+i, randomPassword()))
                .collect(Collectors.toList());
    }

    private String randomPassword() {
        int pwSize = 6 + RNG.nextInt(5);
        char[] chars = new char[pwSize];
        for (int i = 0 ; i < chars.length; i++) {
            chars[i] = (char)('a'+RNG.nextInt(26));
        }
        return new String(chars);
    }

    public static class User {
        private final StringProperty userName = new SimpleStringProperty();
        private final StringProperty password = new SimpleStringProperty();

        public User(String userName, String password) {
            setUserName(userName);
            setPassword(password);
        }

        public final StringProperty userNameProperty() {
            return this.userName;
        }

        public final java.lang.String getUserName() {
            return this.userNameProperty().get();
        }

        public final void setUserName(final java.lang.String userName) {
            this.userNameProperty().set(userName);
        }

        public final StringProperty passwordProperty() {
            return this.password;
        }

        public final java.lang.String getPassword() {
            return this.passwordProperty().get();
        }

        public final void setPassword(final java.lang.String password) {
            this.passwordProperty().set(password);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}