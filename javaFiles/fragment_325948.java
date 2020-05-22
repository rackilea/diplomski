import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TableViewWithPriorityRowColor extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Job> table = new TableView<>();
        table.getColumns().add(column("Name", Job::nameProperty));
        table.getColumns().add(column("Value", Job::valueProperty));
        table.getColumns().add(column("Priority", Job::priorityProperty));

        PseudoClass highPriority = PseudoClass.getPseudoClass("high-priority");
        PseudoClass lowPriority = PseudoClass.getPseudoClass("low-priority");
        table.setRowFactory(tv -> new TableRow<Job>(){
            @Override
            public void updateItem(Job job, boolean empty) {
                super.updateItem(job, empty);
                pseudoClassStateChanged(highPriority, job != null && job.getPriority() == 3);
                pseudoClassStateChanged(lowPriority, job != null && job.getPriority() == 1);
            }
        });

        table.getItems().addAll(createJobs());

        Scene scene = new Scene(new BorderPane(table), 800, 600);
        scene.getStylesheets().add("table-view-with-priority.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public List<Job> createJobs() {
        Random rng = new Random();
        return IntStream.rangeClosed(1, 40)
                .mapToObj(i -> new Job("Job "+i, i, rng.nextInt(3) + 1))
                .collect(Collectors.toList());

    }

    public static <S,T> TableColumn<S,T> column(String title, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col ;
    }

    public static class Job {
        private final StringProperty name  = new SimpleStringProperty();
        private final IntegerProperty value = new SimpleIntegerProperty();
        private final IntegerProperty priority = new SimpleIntegerProperty();

        public Job(String name, int value, int priority) {
            setName(name);
            setValue(value);
            setPriority(priority);
        }

        public final StringProperty nameProperty() {
            return this.name;
        }

        public final String getName() {
            return this.nameProperty().get();
        }

        public final void setName(final String name) {
            this.nameProperty().set(name);
        }

        public final IntegerProperty valueProperty() {
            return this.value;
        }

        public final int getValue() {
            return this.valueProperty().get();
        }

        public final void setValue(final int value) {
            this.valueProperty().set(value);
        }

        public final IntegerProperty priorityProperty() {
            return this.priority;
        }

        public final int getPriority() {
            return this.priorityProperty().get();
        }

        public final void setPriority(final int priority) {
            this.priorityProperty().set(priority);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}