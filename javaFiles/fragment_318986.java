protected Dialog onCreateDialog(int id) {
  Dialog dialog;
  switch(id) {
   case 0:
    dialog = new Dialog(this);

    dialog.setContentView(R.layout.paused);
    dialog.setTitle("Game Paused");
    dialog.show();
    break;
default:
    dialog = null;
}
return null;