AlertDialog.Builder builder = new AlertDialog.Builder (this);
builder.setTitle ("Enter Passcode.");
builder.setView (view);
builder.setPositiveButton (R.string.login, new DialogInterface.OnClickListener ()
{
    public void onClick (DialogInterface dialog, int whichButton)
    {
        if (App.get (passcode).equals (App.getPassword ().substring (0, 4)))
        {
            App.setLoggedIn (true);
            dialog.dismiss ();
        }
        else
        {
            Toast toast = Toast.makeText (MainActivity.this, Error.get (Error.AUTHENTICATION),App.getDelay ());
            toast.show ();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
});
builder.show ();