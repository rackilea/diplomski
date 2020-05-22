private String email;
private String name;
protected void onPreExecute() {
    super.onPreExecute();

    email = Email.getText().toString();
    name = Name.getText().toString();
}