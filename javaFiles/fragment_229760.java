@Override
    public void onPause () {
        super.onPause();
        Log.e("Yes", "I stoped the handler for you");
        stopHandler();
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("Back", "I started the handler for you");
        stopHandler();
        startHandler();
    }