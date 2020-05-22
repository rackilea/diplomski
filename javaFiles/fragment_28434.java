static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

public static int daysToEnd(int day, int month){
    return sum(daysInMonth, month - 1, 12) - day;
}

public static int daysFromStart(int day, int month){
    return sum(daysInMonth, 0, month - 1) + day;
}

public static void main(String... args){
    int[] date1 = {23, 1, 1994};
    int[] date2 = {1, 1, 1997};

    // This actually works for same or different years
    int days = daysToEnd(date1[0], date1[1]) +
               365*(date2[2] - date1[2] - 1) +
               daysFromStart(date2[0], date2[1]);

    System.out.println(days);
}