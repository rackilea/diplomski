public static List<Date> removeFromList1(List<Date> dateList) 
{
    return removeFromList(dateList, currentDate.getDate());
}

public static List<WDate> removeFromList2(List<WDate> dateList) 
{
    return removeFromList(dateList, currentDate);
}