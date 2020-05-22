@Override
    public void onDataChanged(int gameTime) {
        // it will fire when you call your callback.onDataChanged(); in your adapter
        // here can change your textview
        textview.setText(String.valueOf(gameTime));
    }