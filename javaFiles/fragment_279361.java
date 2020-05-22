table.setRowFactory(param ->
    {
        TableRow<Integer> row = new TableRow<>();

        row.disableProperty().addListener((observable, oldValue, newValue) ->
        {
            if (newValue)
                row.setStyle("-fx-background-color: red");
            else
                row.setStyle("");
        });

        row.disableProperty().bind(disable);

        return row;
    });