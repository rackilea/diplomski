payNGO.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            username = usernameField.getText().toString();
            password = passwordField.getText().toString();
            Toast.makeText(login.this, username, Toast.LENGTH_LONG).show();
        }

    });