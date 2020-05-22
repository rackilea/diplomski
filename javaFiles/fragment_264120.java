SharedPreferences prefs = getSharedPreferences("MyData", MODE_PRIVATE);
    String restoredText = prefs.getString("text", null);
    if (restoredText != null) {
        String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
        if (!TextUtils.isEmpty(name)){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }