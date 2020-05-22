public void onClick(View arg0) {
    // TODO Auto-generated method stub
    switch(arg0.getId()){
    case R.id.advanced_button:

        Intent a = new Intent(Registration.this, RegistrationAdvanced.class);

        startActivity(a);
        break;

    }

}