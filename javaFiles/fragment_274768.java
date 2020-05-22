String input = "2016-05-05 03:45:00.907text.txt";
String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+";
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSS");
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);

if(matcher.find()){
    String output  =  matcher.group();

    Date date = formatter.parse(output);
    long time = date.getTime();

    System.out.println(time);
}