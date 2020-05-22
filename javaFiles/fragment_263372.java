public class Test {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\*\\S.*?(?<!\\s)\\*(?=\\s|$)");
        Matcher matcher = pattern.matcher("*foo 1 * 2 bar* foo *b* azz *qu **ux*");
        int i = 1;
        while(matcher.find()) {
            System.out.printf("%d: %s%n", i++, matcher.group());
        }
    }
}