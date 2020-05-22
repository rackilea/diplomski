buttonStop.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(task == null) {
                System.out.println("Task not running");
                return;
            }
            System.out.println("Stop Pressed");
            task.cancel();
            task = null;
        }
    });