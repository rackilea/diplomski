private void request_user_name() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter name:");

        final EditText input_field = new EditText(this);
        //String e  = input_field.getText().toString();
        final SharedPreferences.Editor editor = sharedpreferences.edit();       
        builder.setView(input_field);
        String savedName = sharedpreferences.getString(username,"");
        input_field.setText(savedName);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                  String name = input_field.getText().toString();
                  editor.putString(username, name);
                  editor.apply();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                request_user_name();
            }
        });

        builder.show();
    }