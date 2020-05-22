public class TimeDisplay {

    static int h = 11;
    static int m = 56;
    static int s = 32;
    static String temp;

    public static void main(String[] args) {

        display(Time.format(h, m, s));

    }

    public static void display(String temp) {
        System.out.println(temp);

    }

    public static class Time {

        public static String format(int h, int m, int s) {
            int hour = (h < 24 && h > 0 ? h : 0);
            int minute = (m < 60 && m > 0 ? m : 0);
            int second = (s < 60 && s > 0 ? s : 0);

            return String.format("%02d:%02d:%02d", hour, minute, second);
        }

    }

}