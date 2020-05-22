import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TestDateRanges {

    public static void main(String[] args) {
        try {
            List<Date[]> dates = new ArrayList<>(
                    Arrays.asList(
                            new Date[][]{
                                {makeDate("1.1.2015"), makeDate("5.1.2015")},
                                {makeDate("3.1.2015"), makeDate("10.1.2015")},
                                {makeDate("15.1.2015"), makeDate("20.1.2015")},}
                    )
            );

            Collections.sort(dates, new Comparator<Date[]>() {
                @Override
                public int compare(Date[] o1, Date[] o2) {
                    return o1[0].compareTo(o2[0]);
                }
            });

            List<Date[]> ranges = new ArrayList<>(dates.size());
            Date[] baseRange = null;
            for (Date[] range : dates) {
                if (baseRange == null) {
                    baseRange = range;
                    ranges.add(baseRange);
                } else if ((baseRange[0].before(range[0]) || baseRange[0].equals(range[0])) && (baseRange[1].after(range[0]) || baseRange[1].equals(range[0])) {
                    System.out.println("> Overlap " + format(baseRange) + " <-> " + format(range));
                    if (range[1].after(baseRange[1])) {
                        baseRange[1] = range[1];
                    }
                } else {
                    System.out.println("> Out of range " + format(baseRange) + " >-< " + format(range));
                    baseRange = range;
                    ranges.add(baseRange);
                }
            }

            System.out.println("Has " + ranges.size() + " distinct ranges");

            for (Date[] range : ranges) {
                System.out.println(format(range));
            }
        } catch (ParseException exp) {
            exp.printStackTrace();
        }
    }

    public static final DateFormat FORMAT = new SimpleDateFormat("d.M.yyyy");

    protected static final Date makeDate(String value) throws ParseException {
        return FORMAT.parse(value);
    }

    private static String format(Date[] baseRange) {
        return FORMAT.format(baseRange[0]) + "->" + FORMAT.format(baseRange[1]);
    }

    private static Date[] makeDateRange(String from, String to) throws ParseException {
        return new Date[]{makeDate(from), makeDate(to)};
    }

}