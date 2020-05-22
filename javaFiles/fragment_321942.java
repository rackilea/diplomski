tvForgotPwd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(Login.this, PatientSearch.class);
        startActivity(myIntent);
    }
});