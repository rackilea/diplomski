if (email_text.getText().length() > 0 && code_text.getText().length() > 0) {
    final String userEmail = email_text.getText().toString().substring(0, Math.min(6, email_text.length())).toLowerCase();
    final String userCode = code_text.getText().toString();

    int sleutel = 3;
    long res = 1;
    for(int i=0; i<userEmail.length(); i++)    // loops through userEmail
       res *= getNumber(userEmail.charAt(i)) * sleutel;    // when the loop ends, res will have the correct value

    if (userCode.equals(Long.toString(res))) {
        Intent intent = new Intent(Login.this, Home.class);
        startActivity(intent);
    } else {...} // display toast
}