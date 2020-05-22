tableView.setOnKeyPressed((KeyEvent e) -> {

    if (!tableView.getSelectionModel().isEmpty()
            && e.getCode() == KeyCode.ENTER) {

        System.out.println("edit " + tableView.getSelectionModel().getSelectedItem());

        e.consume();
    }
});