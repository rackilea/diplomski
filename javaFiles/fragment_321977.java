Task<Void> myTask = new Task<>() {
    ...
}
myTask.setOnFailed(workerStateEvent -> {
     System.out.println("Something wrong happened...");
     myTask.getException().printStackTrace();
     // Or handle the problem however suits your application. 
});