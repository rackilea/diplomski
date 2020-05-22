Task<Boolean> loginTask = new Task<Boolean>() {
    @Override
    protected Boolean call() throws Exception {
        return true;
    }
};

loginTask.setOnRunning(e -> {
    //background task(collecting data)
});