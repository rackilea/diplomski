import org.joda.time.LocalDate;

public class WonkyWeeks {
    int year;
    int week;

    public void backUpOneWeek() {
        LocalDate today =
            new LocalDate().withWeekyear(year).withWeekOfWeekyear(week).withDayOfWeek(4);
        LocalDate adayago = today.minusDays(1);
        System.out.println(adayago + " - removed one day");
        LocalDate twodaysago = adayago.minusDays(1);
        System.out.println(twodaysago + " - removed one day");
        LocalDate threedaysago = twodaysago.minusDays(1);
        System.out.println(threedaysago + " - removed one day");
        LocalDate fourdaysago = threedaysago.minusDays(1);
        System.out.println(fourdaysago + " - removed one day");
        LocalDate fivedaysago = fourdaysago.minusDays(1);
        System.out.println(fivedaysago + " - removed one day");
        LocalDate sixdaysago = fivedaysago.minusDays(1);
        System.out.println(sixdaysago + " - removed one day");
        LocalDate lastWeek = sixdaysago.minusDays(1);

        week = lastWeek.getWeekOfWeekyear();
        year = lastWeek.getWeekyear();
        System.out.println(lastWeek + " - Removed one full week");
    }

    public void forwardOneWeek() {
        LocalDate today =
            new LocalDate().withWeekyear(year).withWeekOfWeekyear(week).withDayOfWeek(4);
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow + " - added one day");
        LocalDate dayAfterTomorrow = tomorrow.plusDays(1);
        System.out.println(dayAfterTomorrow + " - added one day");
        LocalDate threeDaysFromNow = dayAfterTomorrow.plusDays(1);
        System.out.println(threeDaysFromNow + " - added one day");
        LocalDate fourDaysFromNow = threeDaysFromNow.plusDays(1);
        System.out.println(fourDaysFromNow + " - added one day");
        LocalDate fiveDaysFromNow = fourDaysFromNow.plusDays(1);
        System.out.println(fiveDaysFromNow + " - added one day");
        LocalDate sixDaysFromNow = fiveDaysFromNow.plusDays(1);
        System.out.println(sixDaysFromNow + " - added one day");
        LocalDate nextWeek = sixDaysFromNow.plusDays(1);

        week = nextWeek.getWeekOfWeekyear();
        year = nextWeek.getWeekyear();
        System.out.println(nextWeek + " - Added one week");
    }

    public void thisWeek() {
        LocalDate thisWeek =
            new LocalDate().withWeekyear(year).withWeekOfWeekyear(week).withDayOfWeek(4);
        System.out.println(thisWeek + " - This is the current week");
    }

    public static void main(String[] args) {
        WonkyWeeks wonky = new WonkyWeeks();
        wonky.week = 2;
        wonky.year = 2015;
        wonky.thisWeek();
        wonky.backUpOneWeek();
        wonky.backUpOneWeek();
        wonky.backUpOneWeek();
        wonky.backUpOneWeek();
        wonky.forwardOneWeek();
        wonky.forwardOneWeek();
        wonky.forwardOneWeek();
        wonky.forwardOneWeek();
    }
}