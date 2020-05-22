Intent i = getIntent();
Bundle b = i.getExtras();

// getting attached intent data
ContactItem contact = (ContactItem) b.getSerializable("DATA_KEY");

// displaying selected contact name
txtName.setText(contact.getName());
txtPhone.setText(contact.getPhone());
txtMobile.setText(contact.getMobile());
txtEmail.setText(contact.getEmail());