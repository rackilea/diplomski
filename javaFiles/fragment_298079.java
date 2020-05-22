final TableView<Media<?>> mediaTable = new TableView<>();
final ObservableList<Media<?>> medium = FXCollections.observableArrayList(
            (Media<?>)new Book(),
            (Media<?>)new CD(),
            (Media<?>)new Book(),
            (Media<?>)new CD(),
            (Media<?>)new Book()
        );