btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Ascode.this);


            String a;
            a = editText1.getText().toString();

            a = a.replace(" ","");
            byte b[] = a.getBytes();
            String[] s = a.split("(?!^)");
            String message = "";

            for(int i=0;i<s.length();i++)
            {
                message += "Value of: \n"+s[i]+ " is " +b[i]+"\n";
            }

            alertDialogBuilder.setTitle("Detailed Output is");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setMessage(message)
                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
});