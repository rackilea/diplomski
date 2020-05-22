@Override
           public void uncaughtException(Thread paramThread,
                           Throwable paramThrowable) {
                   Log.e("Alert", "Restarting app !!!");
                   Intent intent = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPac
           //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTI
           startActivity(intent);
           System.exit(2);
           }
   });