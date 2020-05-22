import java.text.ParseException;

    public interface DateFormatter {

        void formatDate(String dateString, String parserFormat, String outputFormat) throws ParseException;
    }