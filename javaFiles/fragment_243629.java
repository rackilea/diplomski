public void openDialog() {
    final Dialog dialog = new Dialog(context); // context, this etc.
    dialog.setContentView(R.layout.dialog_demo);
    dialog.setTitle(R.string.dialog_title);
    dialog.show();
}