public class MainActivity extends AppCompatActivity {

// add this variable to hold gender value.
private String gender = "";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // your all other code which is already inside onCreate();
    ....
    // [EDIT BEGIN]
    RadioButton genderBtn=(RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
    gender = genderBtn.getText().toString();
    // [EDIT END]
    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.male:
                        gender = "Male";
                        break;
                    case R.id.female:
                        gender = "Female";
                        break;
                }
            }
        });
}


 // Modify submit method like below.
  private void Submit() {

        String Mobile = mobile.getText().toString().trim();
        String Amount = amount.getText().toString().trim();

        if (TextUtils.isEmpty(Mobile)) {
            Toast.makeText(this, "Please enter Mobile", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(Amount)) {
            Toast.makeText(this, "Please enter Amount", Toast.LENGTH_LONG).show();
            return;
        }

        demoRef.push().child("Mobile").setValue(Mobile);
        demoRef.push().child("Amount").setValue(Amount);
        demoRef.push().child("Method").setValue(gender);

}