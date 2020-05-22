SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy");

try {
    String source1 = "Mon Nov 20 14:40:36 2006";
    Date d1 = sdf.parse(source1);
    String source2 = "Mon Nov  6 14:40:36 2006";
    Date d2 = sdf.parse(source2);

    String res1 = sdf.format(d1);
    String res2 = sdf.format(d2);

    System.out.println(source1 +"="+ res1);
    System.out.println(source2 +"="+ res2);
} catch (ParseException e) {
    e.printStackTrace();
}