btnOk.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        wasCancelled = false;
        jdialog.setVisible(false);
    }           
});

btnCancel.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        wasCancelled = true;
        jdialog.setVisible(false);
    }           
});