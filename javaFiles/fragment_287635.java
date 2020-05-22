class displayMessages extends AsyncTask<Void, String, Void> {
    private Boolean shouldPublish;
    public displayMessages(Boolean shouldPublish) {
        this.shouldPublish = shouldPublish;
    }

   @Override
    protected Void doInBackground(Void... nothing) {

        for (int i = 0; i < 100; i++) {
            String currentMessage = i + " " + message;
            if (shouldPublish) {publishProgress(currentMessage);}
            sleepT(500);

        }

        return null;
    }

}