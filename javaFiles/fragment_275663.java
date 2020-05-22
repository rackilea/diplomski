public class Test {
    public static void main(String[] args) throws Exception {
        String html = "<HTML>\n" +
                "<HEAD>\n"+
                "<TITLE>Page 1</TITLE>\n"+
                "<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"+
                "<DIV style=\"position:relative;width:931;height:1243;\">\n"+
                "<STYLE type=\"text/css\">\n"+
                "<!--\n"+
                "    .ft00{font-size:11px;font-family:Times;color:#ffffff;}\n"+
                "    .ft01{font-size:11px;font-family:Times;color:#ffffff;}\n"+
                "-->\n"+
                "</STYLE>\n"+
                "</HEAD>\n"+
                "</HTML>";

        Document doc = Jsoup.parse(html);
        Element style = doc.select("style").first();
        Matcher cssMatcher = Pattern.compile("[.](\\w+)\\s*[{]([^}]+)[}]").matcher(style.html());
        while (cssMatcher.find()) {
            System.out.println("Style `" + cssMatcher.group(1) + "`: " + cssMatcher.group(2));
        }
    }
}