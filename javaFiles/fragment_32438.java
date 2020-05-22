public class TimeCalculator {

    public static void main(String[] args) {
        long sumOfMilliSeconds = 0;
        double array[] = new double[] {
                1.30, 1.00, 1.50, 2.50, 2.10

        };
        for (double d : array) {
            sumOfMilliSeconds = sumOfMilliSeconds + convertToMilliSecounds(d);
        }
        convertDateformat(sumOfMilliSeconds);
    }

    public static void convertDateformat(long milliSeconds) {

        Date date = new Date(milliSeconds);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf.format(date));
    }

    public static long convertToMilliSecounds(double taktTime) {
        long timeInMilliSeconds = (long) (taktTime * 60 * 1000);
        return timeInMilliSeconds;
    }

}