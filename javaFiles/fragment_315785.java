public static void main (String[] args) throws Exception
{
    String foo = "Thu, 21 Apr 2016 18:00:00 +0000";
    SimpleDateFormat f = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ROOT);
    System.out.println(f.parse(foo));
}