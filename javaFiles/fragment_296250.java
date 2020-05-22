public boolean confirmalert(String title,String msg)
{
    wait();
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
    alertDialogBuilder.setMessage(msg);
    alertDialogBuilder.setTitle(title);
    alertDialogBuilder.setPositiveButton("Ok",
            new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface arg0, int arg1)
                {
                    flag=true;
                    notify();
                }
            });

    alertDialogBuilder.setNegativeButton("Cancel",
            new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface arg0, int arg1)
                {
                    flag=false;
                     notify();
                }
            });

    AlertDialog alertDialog = alertDialogBuilder.create();
    alertDialog.show();
    wait();

    return flag;
}