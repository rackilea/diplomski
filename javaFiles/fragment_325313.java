public class Passenger {
    public static enum State {
        New,
        Reserved,
        Paid
    }

    private String name;
    public State state;

    public Passenger(String name, State state){
        this.name = name;
        this.state = state;
    }

    public String toString() {
        return String.format("Passenger{name='%s', state=%s}", name, state.name());
    }
}

class Main {
    public static void main(String[] args) {
        // line read from file
        String stateString = "Reserved";
        // convert string into state
        Passenger.State state = Passenger.State.valueOf(stateString);

        // create the passenger
        Passenger pass = new Passenger("John Doe", state);
        System.out.println(pass);
    }
}