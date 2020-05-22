setContentView(R.layout.main);

contactNumber = (TextView)findViewById(R.id.contactnumber);

Button buttonPickContact = (Button)findViewById(R.id.pickcontact);
buttonPickContact.setOnClickListener(new Button.OnClickListener(){

 @Override
 public void onClick(View arg0) {
// TODO Auto-generated method stub


Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
startActivityForResult(intent, 1);             


 }});
}

@Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
 // TODO Auto-generated method stub
super.onActivityResult(requestCode, resultCode, data);

if(requestCode == RQS_PICK_CONTACT){
if(resultCode == RESULT_OK){
Uri contactData = data.getData();
Cursor cursor =  managedQuery(contactData, null, null, null, null);
cursor.moveToFirst();

  String number =       cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));

  //contactName.setText(name);
  contactNumber.setText(number);
  //contactEmail.setText(email);
       }
     }
   }
 }