public class Passenger {

    //...

    public static class ArrivalComparator implements Comparator<Passenger> {

        public int compare(Passenger one, Passenger two) {
            return Integer.compare(one.getArrivalTime(), two.getArrivalTime());
        }
    }

    //...

}