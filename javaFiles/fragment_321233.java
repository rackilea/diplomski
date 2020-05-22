// TEST.java 20121024_0800
import java.util.regex.*;
public class TEST {
    public static String fixReportAnchorElements(String text) {
        Pattern re_report_anchor = Pattern.compile(
            "<a href=\"http://mypage\\.com/servlets/reports/\\?a=report&id=([^\"]+)\">",
            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = re_report_anchor.matcher(text);
        return m.replaceAll(
            "<a href=\"http://myOtherPage.com/webReports/report.xhtml?id=$1\" target=\"_parent\">"
            );
    }
    public static void main(String[] args) {
        String input =
            "test <a href=\"http://mypage.com/servlets/reports/?a=report&id=MyReport&filters=abcdefg\"> test";
        String output = fixReportAnchorElements(input);
        System.out.println(output);
    }
}