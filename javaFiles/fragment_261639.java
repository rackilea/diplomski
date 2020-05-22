public class Test {
    public Test() {
       final Test me = this;
       synchronized(this) {
          new Thread() {
             @Override
             public void run() {
                // ... Reference 'me,' the object being constructed
                synchronized(me) {
                   // do something dangerous with 'me'.
                }
             }
          }.start();
          // do something dangerous with this
       }
    }
}