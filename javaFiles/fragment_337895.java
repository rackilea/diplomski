public class HeartbeatAgent implements Runnable {

private int DEFAULT_SAMPLING_PERIOD = 5; //seconds
private String DEFAULT_NAME = "HeartbeatAgent";
private HashMap<Integer, Object> values; // <id, value>


public HeartbeatAgent () {
  values = new HashMap<Integer,Object>();

}


private void collect() {
    /** Here you should collect the data you want to send 
        and store it in the hash
    **/

}

public void sendData(){
    /** Here you should send the data to the server. Use REST/SOAP/multicast messages, whatever you want/need/are forced to **/
}

public void run() {
  System.out.println("Running " +  DEFAULT_NAME );
  try {
     while( /** condition you want to stop **/ {
        System.out.println("Thread: " + DEFAULT_NAME + ", " + "I'm alive");

        this.collect();
        this.send();
        // Let the thread sleep for a while.
        Thread.sleep(DEFAULT_SAMPLING_PERIOD * 1000);
     }
 } catch (InterruptedException e) {
     System.out.println("Thread " +  DEFAULT_NAME + " interrupted.");
 }
 System.out.println("Thread " +  DEFAULT_NAME + " exiting.");
}
}