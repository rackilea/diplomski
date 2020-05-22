while (iterator.hasNext()) {
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            (String) iterator.next();
        }
    });
}