int number = 0;  //declare varible

    // Set up the buttons
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            try {
                if(input.getString().toString().Trim().lenght()>0)  //not empty
                {
                    if(Integer.parseInt(input.gettext().toString()) <= 100000 )  //your Int bounds
                    {
                        kolicina = input.getText().toString();
                        number = Integer.parseInt(kolicina);
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("kolicina",kolicina);
                        returnIntent.putExtra("id",id_ji.get(position));
                        setResult(Activity.RESULT_OK,returnIntent);
                        finish();
                    }
                }
            } catch (NumberFormatException e) {

            }
        }
    });