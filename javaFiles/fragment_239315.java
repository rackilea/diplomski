public class RegexDemo {
    public static void main(String[] args) {
        String test = "{q=code=in=(100,110,120,100);product=in=(393,393);ID==33323323, myInfo==test, offset=0, limit=200}";

        printMyInfoValue(test);
    }

    private static void printMyInfoValue(String test) {
        Pattern pattern = Pattern.compile("\\s+myInfo==(\\w+)");
        Matcher matcher = pattern.matcher(test);

        if (matcher.find()) {
            System.out.printf("My Info value: %s\n", matcher.group(1).trim());
        }
    }
}