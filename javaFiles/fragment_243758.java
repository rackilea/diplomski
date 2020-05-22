class CountedBitmapWorkerTask extends BitmapWorkerTask {
protected void onPreExecute() {
    super.onPreExecute();
    updateCounter(1);
}
protected void onPostExecute(String msg) {
        super.onPostExecute();
        updateCounter(-1);

    }
}