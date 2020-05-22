progDailog = ProgressDialog.show(loginAct,"Process ", "please wait....",true,true);

new Thread ( new Runnable()
{
     public void run()
     {
      // your uploading code goes here
     }
}).start();

 Handler progressHandler = new Handler() 
 {

     public void handleMessage(Message msg1) 
     {

         progDailog.dismiss();
         }
 }