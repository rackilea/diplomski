public class Controller {
    private final List<ToDoItem> todoItems = FXCollections.observableArrayList();

    @FXML
    private ListView ToDoList ;

    public void initialize() {
        ToDoList.setItems(todoItems);
        ToDoList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        populate();
    }

    private void populate () {
        todoItems.add(new ToDoItem("Going to Sea","Going to Sea with thamer and kais",
                LocalDate.of(2020, Month.JUNE,16)));
        todoItems.add(new ToDoItem("JavaFx","Getting ready for real programming real world stuff",
                LocalDate.of(2020, Month.JULY,14)));
        todoItems.add(new ToDoItem("Sleep & Chill","Going to Watch Youtube Later & Chill",
                LocalDate.of(2020, Month.JANUARY,13)));
    }
}