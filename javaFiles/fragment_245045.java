String ageText = etAge.getText().toString();
int age = 0;

if(! TextUtils.isEmpty(ageText)) // If EditText is not empty
    age = Integer.parseInt(ageText); // parse its content to integer

// Continue validation...