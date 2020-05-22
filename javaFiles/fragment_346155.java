private void dialogShow()
{
    LayoutInflater li = LayoutInflater.from(context);
    View passView = li.inflate(R.layout.authdialog, null);
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
    // set prompts.xml to alertdialog builder
    alertDialogBuilder.setView(passView);
    final EditText passInput = (EditText) passView.findViewById(R.id.editTextDialogUserInput);
    final TextView txtv = (TextView) findViewById(R.id.textv);
    // set dialog message
    alertDialogBuilder.setCancelable(false)
            .setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
            public void onClick(DialogInterface dialog, int id)
            {
                String data = "";
                try
                {
            FileInputStream fis = openFileInput("authfile");                            InputStreamReader in = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(in);
                data = br.readLine();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            if (data.toString().equals(passInput.getText().toString()))
                    {
                        txtv.setText("You Have Logged in");
                    }
                    else
                    {
                    RetryDialog();//Call the dialog of retry
                    }
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    dialog.cancel();
                }
            });
    // create alert dialog
    AlertDialog alertDialog = alertDialogBuilder.create();
    // show it
    alertDialog.show();
}