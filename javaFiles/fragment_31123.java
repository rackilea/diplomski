private static ObservableList<Double> list;

public static void main(String[] args) throws Exception {
    list = FXCollections.observableArrayList();
    list.addListener((ListChangeListener.Change<? extends Point> change) -> {
        while (change.next()) {
            if (change.wasRemoved() || change.wasAdded()) {
                doSomethingFunction();
            }
        }
    });
}

private static void doSomethingFunction() {
    FXCollections.reverse(list);
}