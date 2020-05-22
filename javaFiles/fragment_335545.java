setOnCancelListener(new OnCancelListener() 
{
    @Override
    public void onCancel(DialogInterface dialog) {
      removeDialog(DIALOG_ALERT);
      finish();
    }
})