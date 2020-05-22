public void click_login(View view) {
        EditText user_txt = (EditText) findViewById(R.id.main_user_txt);
        EditText pass_txt = (EditText) findViewById(R.id.main_pass_txt);

        // Inititialising the string vars here
        userUsername = user_txt.getText().toString();
        userPassword = pass_txt.getText().toString();

        if ( userUsername.equals(AppInfo.adminName) && userPassword.equals(AppInfo.adminPass) ) { 
            Intent intent = new Intent(ctx, StoreAddGeoActivity.class);
            startActivity(intent);
            finish();
        } else { 
            new AuthenticateTask().execute(targetUrl, userUsername, userPassword);
        } 

    }