saveUserInfo.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v)
    {
        try
        {

         final String fullNameText = fullName.getText().toString();

         final String stateText = state.getText().toString();

         final String zipcodeText = zipcode.getText().toString();

         userDB.execSQL("CREATE TABLE IF NOT EXISTS allUsers (name VARCHAR, zipcode VARCHAR, state VARCHAR, id INTEGER PRIMARY KEY)");

         userDB.execSQL("INSERT INTO allUsers(name, zipcode, state) VALUES ( " + fullNameText + ", " + zipcodeText + ", " + stateText + ")");