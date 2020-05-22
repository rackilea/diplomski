protected void onCreate(Bundle savedInstanceState) {    
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_createcontact);   
mEditText1 = (EditText)findViewById(R.id.EmailET);
mEditText2 = (EditText)findViewById(R.id.role);
Bundle extras = this.getIntent().getExtras();
if (extras != null) {
recognizedText = extras.getString("TEXT");
mFromLang = extras.getString("LANG");
textToUse = recognizedText;  
mCurrentLang = mFromLang;   
// textToUse = EmailValidator(textToUse);

if(isValidEmail(recognizedText))
{
textToUse=recognizedText   
 }
else
{
//this is invalid email part
}

setupUI();      
}


public final static boolean isValidEmail(CharSequence target) {
if (TextUtils.isEmpty(target)) {
return false;
} else {
return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
}
}


 public void setupUI(){    
 mEditText1.setText(textToUse);
 mEditText2.setText(textToUse);
 }