import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;

    public class Testclass implements Generator, DateFormatter {

        public static void main(String[] args){
            Testclass stack = new Testclass();
            try {
                stack.generate();
                stack.formatDate("2011-01-18 00:00:00.0", "yyyy-mm-dd hh:mm:ss", "yyyy-mm-dd");
                stack.generate();
                stack.formatDate("2011-01-18 00:00:00.0", "yyyy-mm-dd", "yyyymmdd");
            } catch (ParseException e) {
                // TODO add some more Exceptionhandling here
                System.out.println("The given String could not be parsed.");
                e.printStackTrace();
            }
        }

        @Override
        public void generate() {

        }

        @Override
        public void formatDate(String dateString, String parserFormat, String outputFormat) throws ParseException {
            SimpleDateFormat dt = new SimpleDateFormat(parserFormat);
            Date date = dt.parse(dateString);
            SimpleDateFormat dt1 = new SimpleDateFormat(outputFormat);
            System.out.println(dt1.format(date));
        }
    }