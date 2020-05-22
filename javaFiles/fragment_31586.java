private final DialogInterface.OnClickListener dialogYesListener = new DialogInterface.OnClickListener() {
   public void onClick(DialogInterface dialog, int id) {
      //some logic
   }
};

AlertDialog.Builder builder
builder.setPositiveButton("Yes", dialogYesListener);