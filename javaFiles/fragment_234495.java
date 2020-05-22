final myTextRow addPlaceHolder = new myTextRow(Integer.MIN_VALUE, null, null);

...

//Add data
data = FXCollections.observableArrayList(
        new myTextRow(5, "Lorem", "bla"),
        new myTextRow(2, "Ipsum", "bla"),
        addPlaceHolder
);