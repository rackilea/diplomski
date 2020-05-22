public class ContactFieldActivity extends Activity {
private static final int PICK_NUMBER = 1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.field_contact);

    Button btnContacts = (Button)findViewById(R.id.btn_contacts);

    btnContacts.setOnClickListener(new OnClickListener() {  

        public void onClick(View arg0) {  
            Intent intent = new Intent(Intent.ACTION_PICK, Phones.CONTENT_URI);
            startActivityForResult(intent, PICK_NUMBER);
        }});
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    switch (requestCode) {  
         case (PICK_NUMBER):  
             if (resultCode == Activity.RESULT_OK) {  
                 Uri contactData = data.getData();  
                 Cursor c = managedQuery(contactData, null, null, null, null);  
                 if (c.moveToFirst()) {  
                     String number = c.getString(c.getColumnIndexOrThrow(Phones.NUMBER));
                     EditText edit = (EditText)findViewById(R.id.editNumber);
                     edit.setText(number);  
                 }  
             }  
             break;  
     }      
}