String input = "Wed Jan 01 00:00:00 CST 2014";
SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");

try {
    Date date = inputFormat.parse(input);

    SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
    String output = outputFormat.format(date);

    System.out.println(output); // 01/01/2014

} catch (ParseException e) {
    e.printStackTrace();
}