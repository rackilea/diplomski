alertDialog.setOnCancelListener(new OnCancelListener() {

public void onCancel(DialogInterface dialog) {
   if (First == 1){
       Toast.makeText(getApplication(), "Inside If", Toast.LENGTH_SHORT).show();
   }
   else
   {
       Toast.makeText(getApplication(), "After If Message", Toast.LENGTH_SHORT).show();
   }
});