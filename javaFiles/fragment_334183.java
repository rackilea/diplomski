//start main
Intent getContact = new Intent(this, MainActivity.class); 
getContact.putExtra("Contact",phoneNo);
startActivity(getContact);
// In MainActivity onCreate
String contact = getIntent().getStringExtra("Contact");