ScheduledService<Object> service = new ScheduledService<Object>() {
     protected Task<Object> createTask() {
         return new Task<Object>() {
             protected Object call() {
                 // Connect to a Server
                 // Download the object
                 updateProgress(...);
                 return object; // Useful in case you want to return data, else null
             }
         };
     }
 };
 service.setPeriod(Duration.seconds(10)); //Runs every 10 seconds
 //bind the service progress/message properties
 progressBar.progressProperty().bind(service.progressProperty());