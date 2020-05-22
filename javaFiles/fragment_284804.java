buttonStart.setOnAction(new EventHandler<ActionEvent>() {
    /*
     * Start Button Clicked
     */
    @Override
    public void handle(ActionEvent event) {
        if(task != null) {
            System.out.println("Task already running");
            return;
        }
        task = new Task<Void>() {
            @Override
            protected Void call() {
                new VisitPage().start(this, URLTextField.getText());
                ;
                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
});