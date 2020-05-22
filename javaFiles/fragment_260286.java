you can use data serializable class and use in put extra statements
 Intent i = new Intent(getApplicationContext(), DataList.class);
            i.putExtra("password", (Serializable) contactList);
           startActivity(i);
//and fetch the data as a
if(getIntent().getSerializableExtra("password")!=null)
 {
            con=(ArrayList<Contact>)getIntent().getSerializableExtra("password");
            email_mobile = contactList.get(0)._emnumber;
            pass__word = contactList.get(0)._password;
}