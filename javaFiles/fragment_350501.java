public class Elevator {
    private ElevatorState elevatorState;
    private int currentFloor;
    private Elevator request;

    public Elevator() {
        currentFloor = 1;
        elevatorState = ElevatorState.IDLE; //this is no longer my problem
        request = null;
    }
}