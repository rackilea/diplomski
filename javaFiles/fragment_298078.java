final TableView<Media> mediaTable = new TableView<>();
final ObservableList<Media> medium = FXCollections.observableArrayList(
            new Book(),
            new CD(),
            new Book(),
            new CD(),
            new Book()
        );