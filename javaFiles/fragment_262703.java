public class B implements Runnable {
      private Parent parent;

      public B(Parent p) {
         parent = p;
      }

      public void run() {
         while(parent.isStillRunning()) {
            String data = parent.getData().poll();
            if (data != null) {
              // do more stuff with data
            } else {
              Thread.sleep(10 /*10 ms, but you can make this whatever poll interval you want*/);
            }
         }
      }
   }