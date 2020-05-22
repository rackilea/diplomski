public static void main(String[] args) 
{

    String foo = "CCC=123 CCC=DDD CCC=EEE";
    Pattern p = Pattern.compile("(CCC=(?!123).{3})");
    Matcher m = p.matcher(foo);
    String result = m.replaceAll("CCC=AAA");

    System.out.println(result);

}