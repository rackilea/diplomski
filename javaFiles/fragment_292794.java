private static int count = 0;
public static void run() {
     count++;
     if (count >= 6) {
         timer.cancel();
         timer.purge();
         return;
     }

     ... perform task here ....

}