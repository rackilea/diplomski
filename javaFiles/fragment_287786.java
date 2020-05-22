while (iterator.hasNext()) {
    final String nextValue = (String) iterator.next();
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            // Do stuff with nextValue
        }
    });
}