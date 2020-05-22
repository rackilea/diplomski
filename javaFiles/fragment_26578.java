AtomicBoolean keepRunning = new AtomicBoolean(true);
while (keepRunning.get()) {
    new TextInputDialog().showAndWait()
        .ifPresentOrElse(System.out::println, 
                         () -> keepRunning.set(false));
}
Platform.exit();