private static class MyRunnable implements Runnable {
         WeakReference<YourActivity> activity;
         @Override
         public void run() {
             // do something long
              if(activity.get() != null){
                  activity.get().doSomething();             
              }
         }
     }