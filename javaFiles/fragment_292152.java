new Handler().postDelayed(new Runnable() {

     @Override
     public void run() {
         // TODO Auto-generated method stub
         Intent intent = new Intent(context, CustomDialerActivity.class);
         intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
         context.startActivity(intent);
     }
 }, 2000);