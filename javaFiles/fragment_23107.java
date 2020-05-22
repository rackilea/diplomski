if(TextUtils.isEmpty(etUsername.getText().toString())||TextUtils.isEmpty(etPassword.getText().toString())){
        Intent intent = new Intent(LoginActivity.this, A.class);
        LoginActivity.this.startActivity(intent);
 } else {
        Intent registerIntent = new Intent(LoginActivity.this, B.class);
        LoginActivity.this.startActivity(intent);
 }