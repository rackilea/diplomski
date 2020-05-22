private class MyAsyncTask extends AsyncTask<Integer param, Void, Void>{
    private int time = 0;
    @Override
    protected Void doInBackground(Integer...time){
        this.time = time[0];

        try {
           Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPostExecute(Void result){
        createButton(time-1);
    }
}