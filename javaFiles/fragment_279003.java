public class CountSubstring {
    public static int countSubstring(String subStr, String str){
        // the result of split() will contain one more element than the delimiter
        // the "-1" second argument makes it not discard trailing empty strings
        return str.split(Pattern.quote(subStr), -1).length - 1;
}