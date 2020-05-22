public class ShowBike {

    private static class Bicycle {
        public int gear = 0;
        public Bicycle(int v) {
            gear = v;
        }

    }

    public static void main() {
        Bicycle bike = new Bicycle(5);
        System.out.println(bike.gear);
    }
}