public class FormatDateExample {
    public static void main(String[] args) {
        String date =  "2016-02-26T00:00:00+02:00";
        System.out.println(formatDate(date));

    }

    public static String formatDate(String unFormattedTime) {
         String formattedTime;
         try {
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
             Date date = sdf.parse(unFormattedTime);

             sdf = new SimpleDateFormat("dd MMM HH:mm");
             formattedTime = sdf.format(date);

             return formattedTime;

        } catch (ParseException e) {
             e.printStackTrace();
        }

        return "";
    }
}