public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
        dialogOnBackPress();

        return true;
    }
    return super.onKeyDown(keyCode, event);
}

protected void dialogOnBackPress() {

    new AlertDialog.Builder(this)
           .setMessage("Are you sure you want to exit?")
           .setCancelable(false)
           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                    HomeScreen.this.finish();
               }
           })
           .setNegativeButton("No", null)
           .show();

}