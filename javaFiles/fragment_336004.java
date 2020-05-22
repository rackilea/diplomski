public class PassWagon {
    private int wagonseats ;

    Passenger[] rowA; // Just create, don't initialize yet
    Passenger[] rowB;

    public PassWagon(int seat) {
        this.wagonseats = seat;
        rowA = new Passenger[wagonseats];
        rowB = new Passenger[wagonseats];

        for (int i = 0; i < wagonseats; i++) {
            rowA[i] = new Passenger();
            rowB[i] = new Passenger();
        }   
    }
}