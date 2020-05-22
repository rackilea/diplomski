GregorianCalendar c = new GregorianCalendar(2013, 1, 6);
        c.add(Calendar.DAY_OF_YEAR, Calendar.MONDAY - c.get(Calendar.DAY_OF_WEEK));
        DateFormat df = new SimpleDateFormat("d-M-yyyy");
        while(c.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
            if (c.get(Calendar.YEAR) == 2013) {
                System.out.printf("%-10tA%10s%n", c.getTime(), df.format(c.getTime()));
            }
            c.add(Calendar.DAY_OF_YEAR, 1);
        }
prints

    Monday      4-2-2013
    Tuesday     5-2-2013
    Wednesday   6-2-2013
    Thursday    7-2-2013
    Friday      8-2-2013
from week 6 of 2013:

    GregorianCalendar c = new GregorianCalendar(2013, 0, 1);
    c.add(Calendar.WEEK_OF_YEAR, 6 - 1);
    c.add(Calendar.DAY_OF_YEAR, Calendar.MONDAY - c.get(Calendar.DAY_OF_WEEK));
        DateFormat df = new SimpleDateFormat("d-M-yyyy");
        while(c.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
            if (c.get(Calendar.YEAR) == 2013) {
                System.out.printf("%-10tA%10s%n", c.getTime(), df.format(c.getTime()));
            }
            c.add(Calendar.DAY_OF_YEAR, 1);
        }