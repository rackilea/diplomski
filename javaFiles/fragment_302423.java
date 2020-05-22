public synchronized void addItemToList(String item){
    adapter.add(item);
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            adapter.notifyDataSetChanged();
        }
    });
}