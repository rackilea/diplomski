private void executeSubmitClass() {
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            new SubmitClass().execute();
        }
    });
}