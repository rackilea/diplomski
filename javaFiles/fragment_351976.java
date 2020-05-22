String customPrimaryKey="UserName.getText().toString()+FirstName.getText().toString()+txtPassword.getText().toString()";
db.updateRow
        (
            UserName.getText().toString(),
            FirstName.getText().toString(),
            LastName.getText().toString(),
            txtPassword.getText().toString(),
// add one more value for a particular entry-a primary key for You to identify that row
            customPrimaryKey
        );