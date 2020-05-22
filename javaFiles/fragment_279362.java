table.setRowFactory(param ->
    {
        TableRow<Integer> row = new TableRow<>();

        row.styleProperty().bind(Bindings
            .when(disable)
            .then("-fx-background-color: red;")
            .otherwise(""));

        row.disableProperty().bind(disable);

        return row;
    });