tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldItem, newItem) -> {
        System.out.println(LocalDateTime.now() + " Item selection changed: "+ oldItem + " -> " + newItem);
    });
    tableView.getSelectionModel().selectedIndexProperty().addListener((observable, oldIndex, newInde) -> {
        System.out.println(LocalDateTime.now() + " Item index changed: " + oldIndex + " -> " + newIndex);
    });