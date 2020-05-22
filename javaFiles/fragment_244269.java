public void OnClickButtonListener(){
Button_sbm = (Button) findViewById(R.id.signupbut);
Button_sbm.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.teamsix.fezzy.gosheesh.Signupactivity");
                startActivity(intent);
               }
            });
Button signinbut = (Button) findViewById(R.id.signinbut);
signinbut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent ("com.teamsix.fezzy.gosheesh.SignIn");
                        startActivity(intent);
                     }
});