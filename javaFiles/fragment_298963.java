public class TimeZoneSample {
    public static void main(String[] args) throws ParseException {

        // I am in IST time Zone (Its ID is Asia/Calcutta or ITS)
        System.out.println(TimeZone.getDefault());
        // I get Indian Time printed
        System.out.println(new Date());
        System.out.println("-------------------");
        // I am setting the time zone to China
        TimeZone.setDefault(TimeZone.getTimeZone("CTT"));
        // Now my default time zone is in China
        System.out.println(TimeZone.getDefault());
        // I get Chian Time printed
        System.out.println(new Date());
        System.out.println("-------------------");
        // I am setting the time zone to EST
        TimeZone.setDefault(TimeZone.getTimeZone("EST"));
        // Now my default time zone is in EST
        System.out.println(TimeZone.getDefault());
        // I get Eastern Time printed
        System.out.println(new Date());

    }

}