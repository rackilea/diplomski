public void onResponse(final JSONObject response) {
    Runnable actualRunnable = new Runnable() {
        public void run() {
            oldOnResponse(response);
        }
    };

    (new Thread(actualRunnable)).start();
}