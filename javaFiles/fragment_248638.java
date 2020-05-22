private EditText mEmail;
private EditText mPassword;

Button btn_login,btn_signup;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);


    btn_login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

                uid = mEmailView.getText().toString();
                pwd = mPasswordView.getText().toString();

                if(uid.equalsIgnoreCase("")){
                    mEmailView.setError("Please enter user id");
                }else if(pwd.equalsIgnoreCase("")){
                    mPasswordView.setError("Please enter password");
                }else  {
                    //do whaterver you want to do after login
                }

        }
    });

            btn_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(LoginActivity.this,Signup.class);
                    startActivity(i);
        }
    });
}