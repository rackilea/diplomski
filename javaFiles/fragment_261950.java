public class Extraction {
    public final String original;
    public String year = "";
    public String title = "";
    public String country = "";

    private String remaining;

    public Extraction(String s) {
        this.original = s;
        this.remaining = s;
        extractBracketedYear();
        extractBracketedCountry();
        this.title = remaining;
    }

    private void extractBracketedYear() {
        Matcher matcher = Pattern.compile(" ?\\(([0-9]+)\\) ?").matcher(remaining);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            this.year = matcher.group(1);
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        remaining = sb.toString();
    }

    private void extractBracketedCountry() {
        Matcher matcher = Pattern.compile("\\((Germany|International: English.*?)\\)").matcher(remaining);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            this.country = matcher.group(1);
            matcher.appendReplacement(sb, "");
        }
        matcher.appendTail(sb);
        remaining = sb.toString();
    }

    public static void main(String... args) {

        for (String s : new String[] {
                "A Fatal Inversion (1992)",
                "(aka \"Verhngnisvolles Erbe\" (1992))    (Germany)",
                "\"#Yaprava\" (2013) ",
                "(aka \"Love Heritage\" (2002)) (International: English title)"}) {

            Extraction extraction = new Extraction(s);
            System.out.println("title   = " + extraction.title);
            System.out.println("country = " + extraction.country);
            System.out.println("year    = " + extraction.year);
            System.out.println();
        }
    }

}