public static boolean isEarlierThan (String date1, String date2)
{

    String month1 = date1.substring(0, 2);
    String month2 = date2.substring(0, 2);

    String day1 = date1.substring(3, 5);
    String day2 = date2.substring(3, 5);

    String year1 = date1.substring(6, 10);
    String year2 = date2.substring(6, 10);

    date1 = year1 + month1 + day1; // + month1 + day1
    date2 = year2 + month2 + day2; // + month2 + day2

    if (date1.compareTo(date2) < 0)
    {
        return true;
    }
    else if (date1.compareTo(date2) > 0)
    {
        return false;
    }
    else
    {
        return false;
    }
}