new Thread() {
    public void run() {  
        YourActivity.this.runOnUiThread(new Runnable(){

             @Override
             public void run(){
                 try {
                      startPayment("Bank");//Edit,integrate this on the runOnUiThread
                 } catch (Exception e) {
                     alertDialog.setMessage(e.getMessage());
                     handler.sendEmptyMessage(1);
                     progressDialog.cancel();
                 } 
            });                
           }
      }
  }.start();