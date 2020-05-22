import java.util.ArrayList;

public class User {
    // some fields to test
    String name;
    boolean active;
    //volatile means all writes up to the volatile variable 
    //from other any thread are now visible to all other threads.
    //so they can share working on that variable
    static volatile boolean finishFirst = false; // to announce first thread finish
    static volatile boolean finishSecond = false; // to announce second thread finish
    static volatile boolean found = false; // // to announce if an active user found

    /**
     * Simple Constructor
     * @param name
     * @param active
     */
    public User(String name, boolean active){
        this.name = name;
        this.active = active;
    }


   public static void main(String[] args) {

     // create an ArrayList of type User
     ArrayList<User> list = new ArrayList<User>();

     // populate it with 1 MILLION user!!
     int i=0;
     for(;i<1000000; i++){
         // make only the one in the very middle active to prolong the search to max
         if(i==500000){
             list.add(new User(String.valueOf(i),true));
         }
         else{
             list.add(new User(String.valueOf(i),false));
         }

     }
     System.out.println("End of Adding " + i + " User" );

     // to measure how long it will take
     long startTime, endTime;
     startTime = System.currentTimeMillis();

     System.out.println("Found Any Active: "+ isAnyActive(list)); // invoke the method

     endTime = System.currentTimeMillis();
     System.out.println(endTime-startTime + " MilliScond");




   }

   public static boolean isAnyActive(ArrayList<User> list){
       found = false;

       // create two threads, each search the half of the array
       // so that shall save time to half
       Thread t1 = new Thread(new Runnable(){
         @Override
         public void run() {
            // read one more index in case the size is not an even number
             // so it will exceed the middle in one -> no problem at all
             for(int i=0; i<=(list.size()/2)+1; i++){ 
                   if(list.get(i).active) {
                       found = true;
                       finishFirst = true;
                       break; 
                   }
             } 
             finishFirst = true; // in case did not find any 
         }  
       });

       // second thread the same, but read from the end to the middle 
       Thread t2 = new Thread(new Runnable(){
             public void run() {
                 for(int i=list.size()-1; i>=list.size()/2; i--){
                       if(list.get(i).active) {
                           found = true;
                           finishSecond = true;
                           break; 
                    }
                 }
                 finishSecond = true;
            }      
       });

       // start both thread
       t2.start();
       t1.start();

       // while one of them has not finished yet
       while(!finishFirst || !finishSecond){
        // but in case not finished looping but found an active user
           // break the loop
               if(found){break;} 
        }

       return found; // return the result
   } 
}