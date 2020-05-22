b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            db1=openHelper.getWritableDatabase();
            String username =e1.getText().toString();
            String password =e2.getText().toString();
            String confirm_password =e3.getText().toString();
            if (password.equals(confirm_password)) {
                insert_data(username, password, confirm_password);
            } else {
                Toast.makeText(v.getContext(),"Password and Confirm Password do not match. Data not added.",Toast.LENGTH_LONG).show();
            }
        }
    });