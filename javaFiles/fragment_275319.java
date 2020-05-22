public static void main(String[] args) {
    String d = DateAndTimeCustom("Date(1542002443000)");
    System.out.println(d);
}

public static String CleanDate(String input) {
    //  remove all non numeric characters
    return input.replaceAll("[^\\d]", "");
}

public static String DateAndTimeCustom(String input) {
    // Build a date based on the cleaned time-stamp
    Date d = new Date(Long.parseLong(CleanDate(input)));
    SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss aa", Locale.ENGLISH);
    String formattedDate  = df.format(d);

    return  formattedDate;

}