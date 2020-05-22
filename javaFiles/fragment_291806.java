table1.getSelectionModel().selectedItemProperty().addListener((obs, oldItem, newItem) -> {
        if (newItem != null) {
            table2.getSelectionModel().clearSelection();
        }
    });

    table2.getSelectionModel().selectedItemProperty().addListener((obs, oldItem, newItem) -> {
        if (newItem != null) {
            table1.getSelectionModel().clearSelection();
        }
    });