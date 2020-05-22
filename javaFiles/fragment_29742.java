public class Mainstackquestion {
       public static void main(String args[])
       {
           List<Thread> allThreads = new ArrayList<>();

           if(args.length > 0) {
               for (String filename : args) {
                   Thread t = CheckFile(filename);
                   allThreads.add(t);  // We save this thread for later retrieval
                   t.start(); // We start the thread
               }
           }
           else {
               Thread t = CheckFile("C:\\Users\\User\\Desktop\\files"); 
               allThreads.add(t);
               t.start();               
           }

           try {
               for (Thread t : allThreads) {
                   t.join(); // We wait for the completion of ALL threads
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

     private static Thread CheckFile(String file) {
         Runnable tester = new WordCountstackquestion(file);
         return new Thread(tester);
     }
}