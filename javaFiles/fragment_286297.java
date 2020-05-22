service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
     @Override
     public void handle(WorkerStateEvent t) {
          service.setPeriod(Duration.seconds(1 + Math.random()*100));
     }
});