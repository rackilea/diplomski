import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.stream.IntStream;

public class Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TableView<Person> tableView = new TableView<>();
        tableView.setTableMenuButtonVisible(true);
        IntStream.range(0, 15).forEach(value -> {
            TableColumn<Person, String> tableColumn = new TableColumn<>("TableColumn" + value);
            tableColumn.setPrefWidth(100.0);
            tableView.getColumns().add(tableColumn);
        });

        IntStream.range(1, 10).forEach(value -> {
            Person person = new Person("Person" + value, value);
            tableView.getItems().add(person);
        });
        Scene scene = new Scene(new StackPane(tableView));
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}