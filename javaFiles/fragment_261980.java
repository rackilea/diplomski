//Updated use this to create a new Service object instead
    Service service = new Service() {
    @Override
    protected Task createTask() {
        return new Task() {
            @Override
            protected Void call() throws Exception {
                //Your codes here
                return null;
            }
        };
    }
};

@FXML protected void launch(ActionEvent event){
     if (!service.isRunning()) {
        service.reset();
        service.start();
    }
}