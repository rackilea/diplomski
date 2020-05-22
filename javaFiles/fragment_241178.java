public class Calculator {

    private String distance(int destination, boolean isMiles) 
            throws IllegalArgumentException {
            if (destination < 0) {
                throw new IllegalArgumentException();
            }
            return String.format(destination + "  " +
                new DecimalFormat("#.###").format(
                        isMiles ? destination / 0.621371192 : destination / 1.609344));
        }
}