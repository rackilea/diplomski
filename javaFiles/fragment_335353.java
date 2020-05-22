studentid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Cursor c = db.rawQuery("SELECT * FROM " + STUDENT_TABLE + " WHERE studentid='" + s.toString() + "'", null);
                if (c.moveToFirst()) {
                    fname.setText(c.getString(1));
                    lname.setText(c.getString(2));
                } else {
                    fname.setText("");
                    lname.setText("");
                }
                c.close();
            }
        });