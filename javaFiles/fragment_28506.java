final String user_id;
    String data = getIntent().getStringExtra("user_id");
    if (data == null) {
        user_id = getIntent().getStringExtra("from_user_id");
    } else {
        user_id = getIntent().getStringExtra("user_id");
    }