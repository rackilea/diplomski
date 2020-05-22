@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bt_SignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String theusername = String.valueOf(username.getText());
            String thepass = String.valueOf(pass.getText());
            if (theusername.equals("schueler") && thepass.equals("123456")) {
                setLehrerPref(false);
                startFrontPage();
            } else if (theusername.equals("lehrer") && thepass.equals("14869")) {
                setLehrerPref(true);
                startFrontPage();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Login fehlgeschlagen :(", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    });
}

private void setLehrerPref(boolean b){
    SharedPreferences sharedPreferences = getSharedPreferences("LehrerPreferences", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putBoolean("LehrerPref", b);
    editor.apply();
}

private void startFrontPage(){
    Toast toast = Toast.makeText(getApplicationContext(), "Login erfolgreich! :D", Toast.LENGTH_SHORT);
    toast.show();
    Intent i = new Intent(getApplicationContext(), Frontpage.class);
    startActivity(i);
}