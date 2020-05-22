@Override
public void onClick(View v) {
    // TODO Auto-generated method stub
    switch (v.getId()) {
        case R.id.login:
            String username = user.getText().toString();
            String password = pass.getText().toString();

            AttemptLogin attempt = new AttemptLogin(username, password);
            attempt.execute();
            break;
        case R.id.register:
            Intent i = new Intent(this, register.class);
            startActivity(i);
            break;

        default:
            break;
    }
}