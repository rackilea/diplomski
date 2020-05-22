public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String format = "HH:mm:ss";
    System.out.println("Please give the desired time in this fomrat HH:mm:ss ...");
    String inp = s.nextLine();
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    try {
        Date date = sdf.parse(inp);
        System.out.println("this is the date:" + date);
    } catch (ParseException e) {
        System.err.println("invalid date...");
    }
}