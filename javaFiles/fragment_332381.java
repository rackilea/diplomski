String str ="[0-S1|0-S2|1-S3, 1-S1|0-S2|0-S3, 0-S1|1-S2|0-S3]";
Matcher m = Pattern.compile("\\d+(?=-)").matcher(str);
while(m.find())
{
    System.out.println(m.group());
}