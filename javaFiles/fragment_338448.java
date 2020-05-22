Button b = new Button("Button!");
b.setOnAction(e -> {
    b.setDisable(true);
    Task<Void> task = new Task<Void>(){
        @Override
        protected Void call() throws Exception {
            Platform.runLater(() -> b.setText("Modified text")); // Use Platform.runLater here to modify the scene graph
            Thread.sleep(3000); 

            return null;
        }
    };

    task.setOnSucceeded(v -> {
        System.out.println("Succeed");
        b.setText("Button!");
        b.setDisable(false);
    });

    Thread thread = new Thread(task);
    thread.setDaemon(true);
    thread.start();
});