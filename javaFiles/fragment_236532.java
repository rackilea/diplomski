tableView.getSelectionModel().selectedItemProperty().addListener((observable) -> {
        System.out.println(LocalDateTime.now() + " Item selection changed: "+tableView.getSelectionModel().getSelectedItem());
    });
    tableView.getSelectionModel().selectedIndexProperty().addListener((observable) -> {
        System.out.println(LocalDateTime.now() + " Item index changed: " + tableView.getSelectionModel().getSelectedIndex());
    });