builder.setPositiveButton ("Yes", new DialogInterface.OnClickListener()
                             {
  public void onClick (DialogInterface dialog, int which)
  {
    //do stuff beforehand
    dialog.dismiss();
  }
});