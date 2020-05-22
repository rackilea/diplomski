public String getDateDiffString(Date dateOne, Date dateTwo)
{
    long timeOne = dateOne.getTime();
    long timeTwo = dateTwo.getTime();
    long oneDay = 1000 * 60 * 60 * 24;
    long delta = (timeTwo - timeOne) / oneDay;

    if (delta > 0) {
        return "dateTwo is " + delta + " days after dateOne";
    }
    else {
        delta *= -1;
        return "dateTwo is " + delta + " days before dateOne";
    }
}