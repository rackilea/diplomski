firstNameCol.setCellFactory(col -> {
        TableCell<Person, String> cell = new TableCell<Person, String>() {
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(name);
                }
            }
        };
        cell.getStyleClass().add("no-select-cell");
        return cell ;
    });