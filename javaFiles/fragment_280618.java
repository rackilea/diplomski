public class Farmer extends Thread{
    private String location;    //current location
    private String destination; //Opposite location, destination, set in the constructor
    private String id;          //name      
    private Bridge bridge;      //bridge being used
    private boolean finished=false;
    private boolean counted = false;

    //constructor
    public Farmer(String id, String location, Bridge bridge) {
        this.id=id;
        this.location=location;
        if (location=="North") destination="South"; //Island objects are not necessary for this particular implementation, as our options are merely North or South
        else destination="North";
        this.bridge = bridge;
        System.out.println(id+": Waiting for bridge. Going towards "+destination);  //print initial waiting for bridge

    }

    //getters
    public String getLocation() {
        return location;
    }
    public String getID() {
        return id;
    }
    public boolean isCounted() {
        return counted;
    }
    //setter
    public void setFinished(boolean finished) {
        this.finished=finished;
    }
    public void counted() {
        counted=true;
    }

    //Overrides the Thread toString() method. Called with Thread.getCurrent().toString()
    @Override   
    public String toString() {
        return id;
    }
    @Override   //initiatied when the Farmer Thread .start() method is called
    public void run() {
        //if ready to cross

        while (!finished) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            if (bridge.getNorth() != 2 && bridge.getSouth() != 2 && !counted) { //if neither equal 2 yet and we havent added this to the list
                bridge.upThis(this);    //increments the appropriate north/south counter in a thread safe method, also marks this thread as counted=true
            }
            if (counted && bridge.getNorth()==2 && id.startsWith("N")) {    //if this has been counted, and is a northern farmer and there are 2 northern farmers ready
                bridge.cross(this);
                bridge.exit();
                finished=true;
                if (bridge.getExited()==2) {    //if both successfully crossed reset counts
                    bridge.resetExited();
                    bridge.resetNorth();
                    //System.out.println("Reset exited and North"); //DEBUG
                    //System.out.println("Exit: "+bridge.getExited()+", North: "+bridge.getNorth()+", South: "+bridge.getSouth()); //DEBUG
                }
            }
            else if (counted && bridge.getSouth()==2 && id.startsWith("S")) { //else if this has been counted, and is a southern farmer and there are 2 southern farmers ready
                bridge.cross(this);
                bridge.exit();
                finished=true;
                if (bridge.getExited()==2) {    //if both successfully crossed reset counts
                    bridge.resetExited();
                    bridge.resetSouth();
                    //System.out.println("Reset exited and South"); //DEBUG
                    //System.out.println("Exit: "+bridge.getExited()+", North: "+bridge.getNorth()+", South: "+bridge.getSouth()); //DEBUG
                }
            }

        }
    }//end run  

}//end class