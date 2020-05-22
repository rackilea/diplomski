executor = Runnable::run;

executor = (Runnable command) -> command.run();

executor = new Executor() {
    public void execute(Runnable command) {
        command.run();
    }
}