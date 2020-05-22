runOnUiThread(new Runnable() {
    public void run() {
          new AlertDialog.Builder(Logger.this)
          .setTitle("Bağlantı Sorunu")
          .setMessage("İnternet bağlantısını kontrol edip tekrar deneyin")
          .setCancelable(false)
          .setPositiveButton(R.string.yeniden, new DialogInterface.OnClickListener() 
           {               
             public void onClick(DialogInterface dialog, int which) 
             { 
                  Logger.isBoxOpen = false;// Try Again
             }
           })
           .show();
     }
});