//we should resuse once compiled regex, there is no point in compiling it many times
private static Pattern pattern = Pattern.compile("/accounts/([^/]+)");
public static String extractAccountIdFromURL(String url) {
    Matcher matcher = pattern.matcher(url);
    return matcher.find() ? matcher.group(1) : null;
}

public static void main(java.lang.String[] args) throws Exception {
    String examples = 
            "http://localhost:8024/accounts/u8m21ercgelj/\r\n" + 
            "http://localhost:8024/accounts/u8m21ercgelj\r\n" + 
            "http://localhost:8024/accounts/u8m21ercgelj/users?";
    for (String url : examples.split("\\R")){// split on line separator like `\r\n`
        System.out.println(extractAccountIdFromURL(url));
    }
}