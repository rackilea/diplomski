public static void main(String[] args)
{
    Pattern p = Pattern.compile("^\\-?\\s?\\d+\\s?[\\+\\-*\\/\\^]\\s?\\-?\\s?\\d+\\r?\\n?$");
    System.out.println(p.matcher("123+").matches()); // outputs "true"
    System.out.println(p.matcher("123").matches()); // outputs "false"
    System.out.println(p.matcher("- 123123 *").matches()); // outputs "true"
    System.out.println(p.matcher("- 9843 * 23409").matches()); // outputs "true"
}