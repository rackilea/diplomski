Handler handler = new Handler(); 
handler.postDelayed(new Runnable() { 
   public void run() { 
   if (playerimage.getVisibility() == View.VISIBLE) {
      currentscore.setText("Game over");
      }
   } 
}, 1500);