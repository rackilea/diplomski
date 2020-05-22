final String[] name = new String[1];
final EditText input = new EditText(this);

 new AlertDialog.Builder(this)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setTitle("New player")
        .setMessage("Input new player's name")
        .setView(input)
        .setPositiveButton("Register", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               name[0] = input.getText().toString(); <---HERE! want to use this variable 
            }
        })
        .setNegativeButton("Cancel", null)
         .show();