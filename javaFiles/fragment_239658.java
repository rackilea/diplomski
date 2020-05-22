if (!enabled) {
    final Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            login.setEnabled(true);
            prefs.edit().clear().apply();
            counter = 2;
        }
    }, 30000);
}