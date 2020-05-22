public static void main(String[] args)
{
    Pattern p = Pattern.compile("[A-Z]*");
    Matcher matcher = p.matcher("CSE");
    while (matcher.find()) {
        System.out.println(matcher.group());
    }
}