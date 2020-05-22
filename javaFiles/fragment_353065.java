public class MilliSecondToDate {
    public static void main(String[] args) {
        long milliSecond = 1509966414000L;
        Date date = new Date(milliSecond);
        System.out.println(date);
    }
}