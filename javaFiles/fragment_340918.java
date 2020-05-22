public class nullPoint {
    public FirebaseResponseListener listener; 

    //the class gets asynchronous data from the Firebase database and does not know when the process will end
    public void takeCount(){

        //det data
        //.
        //.
        // finish

        //send data to MainActivity and update textView text
        listener.onFirebaseResponseReceived(5);
    }
}