public static void main(String[] args) throws IOException {
    Locale ukLocale = new Locale("uk");
    DateFormat df = new SimpleDateFormat("MMM", ukLocale);
    Calendar cal = Calendar.getInstance();
    for (int i = 0; i < 11; i++) {
        cal.set(Calendar.MONTH, i);
        System.out.println(df.format(cal.getTime()));
    }
}