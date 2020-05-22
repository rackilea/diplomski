sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);  
     SharedPreferences.Editor editor = sharedpreferences.edit();

    e1 = (EditText)findViewById(R.id.editText);
    e2 = (EditText)findViewById(R.id.editText2);

    String homewifi = sharedpreferences.getString(HOMEWIFI, "");
    String officeWifi = sharedpreferences.getString(OFFICEWIFI, "");

    e1.setText(homewifi);
    e2.setText(officeWifi);


        b1 = (Button)findViewById(R.id.button3);

       Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String homewifi  = e1.getText().toString();
                String officewifi  = e2.getText().toString();



                editor.putString(HOMEWIFI, homewifi);
                editor.putString(OFFICEWIFI, officewifi);
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_SHORT).show();

            }
        });