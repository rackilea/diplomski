CustomTask task = new CustomTask() {
    @Override
    protected void onPostExecute(Long result) {
        super.onPostExecute(result);
        MyActivity.this.doX();
    }
}.execute();