public static final int IDLE = 0;
public static final int TO_SOURCE = 1;
public static final int TO_DESTINATION = 2;

public Elevator(){
    currentFloor = 1; 
    elevatorState = IDLE; //this is no longer my problem
    request = null;
}