private void handleCustomkey() {
    SharedPreferences app_preferences = 
            getSharedPreferences("com.keyboard.test_preferences", Context.MODE_PRIVATE);

    String ck = app_preferences.getString("Customkey", "0");
    this.getCurrentInputConnection().commitText(ck, 1);


    }