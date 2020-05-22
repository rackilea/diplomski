//Shows the Retry Dialog 
private void RetryDialog()
{
     LayoutInflater ln = LayoutInflater.from(context);
     View invalidView = ln.inflate(R.layout.activity_main, null);
    AlertDialog.Builder invalidDialogBuild = new AlertDialog.Builder(context);
    // invalidDialogBuild.setView(invalidView);
    // set dialog message
    invalidDialogBuild.setCancelable(false)
            .setPositiveButton("Retry", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    dialogShow();
                    dialog.cancel();
                }
            }).setNegativeButton("Reset", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    dialog.cancel();

                }
            });

    AlertDialog invalidDialog = invalidDialogBuild.create();
    // show it
    invalidDialog.show();

}