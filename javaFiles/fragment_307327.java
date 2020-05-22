public static int lastDayM(int month, int year){
    //calculate last day for every month
    //status: working 
    if (month == 3 || month == 5 || month == 8 || month == 10)
        return 30;
    if(month == 1){
        if (year % 4 == 0){
            return 29;
        }
        return 28;
    }
    return 31;
}

public static int firstDayM(int month, int year, int janOneDay){
    int firstDayM = janOneDay;

    for(int i=0; i<month; i++){
        firstDayM += lastDayM(i, year);
    }

    return firstDayM % 7;
}