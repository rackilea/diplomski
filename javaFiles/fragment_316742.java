public class StackOverflowSample {
    public static void main(String[] args) {
        String stringDate  = "Fri Feb 26 14:14:40 CST 2016";
        Date date = convertToDate(stringDate);
        System.out.println(date);
    }

    public static Date convertToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        Date convertedCurrentDate = null;
        try {
            convertedCurrentDate = sdf.parse(date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return convertedCurrentDate;
    }
}