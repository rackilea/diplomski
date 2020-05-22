builder.setPositiveButton(...);

// you're missing this
final AlertDialog alertDialog = builder.create();

// then, use it like this
alertDialog.getButton(DialogInterface.Button_POSITIVE).performClick();