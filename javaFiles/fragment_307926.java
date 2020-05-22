import java.util.*;
import java.text.*;

public class Test {

    public static void main(String[] args) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        System.out.println(parseFully(dateFormat, "2015-02-02"));
        System.out.println(parseFully(dateFormat, "2015-02-02 23:23:23"));
    }

    private static Date parseFully(DateFormat format, String text) 
          throws ParseException {
        ParsePosition position = new ParsePosition(0);
        Date date = format.parse(text, position);
        if (position.getIndex() == text.length()) {
            return date;
        }
        if (date == null) {
            throw new ParseException("Date could not be parsed: " + text,
                                     position.getErrorIndex());
        }
        throw new ParseException("Date was parsed incompletely: " + text,
                                 position.getIndex());
    }
}