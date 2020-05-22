public static void main(String[] args)  Exception {
    String date1 = "05.02.2013, 13:38:14";
    String date2 = "05.02.2013, 09:38:14";
    System.out.println(getOlder(date1, date2)); // 05.02.2013, 13:38:14
    System.out.println(getOlder(date2, date1)); // 05.02.2013, 13:38:14
}

public static String getOlder(String one, String two) throws ParseException {
    Date dateOne = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss").parse(one);
    Date dateTwo = new SimpleDateFormat("dd.MM.yyyy, HH:mm:ss").parse(two);
    if (dateOne.compareTo(dateTwo) > -1) {
        return one; // or return dateOne;
    }
    return two; // or return dateTwo;
}