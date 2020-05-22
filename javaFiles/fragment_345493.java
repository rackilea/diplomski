Loading thread = new Loading(new LoadingHandler() {
    @Override
    public void beforeExecute() {
        disableButtons();
    }

    @Override
    public void afterExecute() {
        enableButtons();
    }
});

new Thread(thread).start();