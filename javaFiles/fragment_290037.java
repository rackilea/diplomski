import java.util.Scanner;

public class TestSharedVariable {
   static volatile MutableObject mutableObject = new MutableObject();

   public static void main(String[] args) {
      // For reading from keyboard
      Scanner keyboard = new Scanner(System.in);

      Printer p = new Printer(mutableObject);
      new Thread(p, "Print thread").start();

      // Reads a line from keyboard into the shared variable
      while (!mutableObject.getData().equals("quit")) {
         mutableObject.setData(keyboard.nextLine());

      }
   }
}

class Printer implements Runnable {
   private volatile MutableObject mutableObject;

   public Printer(MutableObject mutableObject) {
      this.mutableObject = mutableObject;
   }

   /* Prints the line each 2 sec */
   @Override
   public void run() {
      while (!mutableObject.getData().equals("quit")) {
         try {
            Thread.sleep(2000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         Thread thread = Thread.currentThread();
         System.out.println(thread.getName() + ": " + mutableObject);
      }
   }
}

class MutableObject {
   private String data = "";

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   @Override
   public String toString() {
      return data;
   }

}