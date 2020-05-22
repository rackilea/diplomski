try {
    String id = txtId.getText().toString();
    String username = txtUsername.getText().toString();
    SipProfile.Builder builder1 = new SipProfile.Builder(id, username);

}
catch(java.text.ParseException e){
    e.printStackTrace();
}