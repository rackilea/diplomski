private void update() {
    runOnUiThread(new Runnable() {
        public void run() {
            myAdapter.notifyDatasetChanged();
        }
    }
}