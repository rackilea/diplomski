private void tryAgain(){
    new AlertDialog.Builder(this)
    .setTitle("Game Over")
    .setMessage("Times Up!")
    .setPositiveButton("Try Again?", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) { 
            dialog.cancel();
            Intent retry = new Intent(this, Stage1_3.class);//I guess Stage1_3 is the current activity
            finish();
            startActivity(retry);
        }
     })
    .setNegativeButton("Back to Menu", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) { 
            dialog.cancel();
            Intent i = new Intent(Stage1_3.this, ShapingColors.class);
            finish();
            startActivity(i);
        }
     })
     .show();   
}