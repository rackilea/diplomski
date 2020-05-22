//In the base class 
public static Object lock = new Object();

//In the first class
public void execute() {
    synchronized(lock) {
        //do stuff
    }
}

//In the second class
public void execute() {
    synchronized(lock) {
        //do stuff
    }
}