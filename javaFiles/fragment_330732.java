import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class FilterStartAndEndDate {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Collection<Date> dateList = null;
    private Date start = null;
    private Date end = null;

    private FilterStartAndEndDate() throws ParseException {
        dateList = new ArrayList<Date>() {{
            add(sdf.parse("01/01/2016"));
            add(sdf.parse("02/01/2016"));
            add(sdf.parse("03/02/2016"));
            add(sdf.parse("04/01/2016"));
            add(sdf.parse("05/01/2016"));
        }};

        start = sdf.parse("31/12/2015");
        end = sdf.parse("01/02/2016");
    }

    /**
     * Filter dates with Lambda
     *
     * @throws ParseException
     */
    private void getDatesBetweenStartAndFinishWithFilter() throws ParseException {
        dateList.stream()
                .filter(dates -> dates.after(start) && dates.before(end))
                .collect(Collectors.toList())
                .forEach(januaryDate->System.out.println(januaryDate));
    }

    /**
     * Filter dates with Iterator
     *
     * @throws ParseException
     */
    private void getDatesBetweenStartAndFinish() throws ParseException {
        Collection<Date> datesInJanuaryList = new ArrayList<>();

        for (Date eachDate : dateList) {
            if (eachDate.after(start) && eachDate.before(end)) {
                datesInJanuaryList.add(eachDate);
            }
        }

        for (Date eachDate : datesInJanuaryList) {
            System.out.println(eachDate);
        }
    }


    public static void main(String[] args) throws Exception {
        FilterStartAndEndDate datesInJanuary = new FilterStartAndEndDate();
        datesInJanuary.getDatesBetweenStartAndFinish();
        datesInJanuary.getDatesBetweenStartAndFinishWithFilter();
    }
}