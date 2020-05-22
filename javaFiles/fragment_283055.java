public class Test {
    public static void main(String[] argv) {
        Pattern p = Pattern.compile("<!-- wikibase-toolbar --><span class=\"wikibase-toolbar-container\"><span class=\"wikibase-toolbar-item " +
            "wikibase-toolbar \">\\[<span class=\"wikibase-toolbar-item wikibase-toolbar-button wikibase-toolbar-button-edit\"><a " +
            "href=\"/wiki/Special:SetSiteLink/(.*?)\">edit</a></span>\\]</span></span>");
        String line = "<!-- wikibase-toolbar --><span class=\"wikibase-toolbar-container\"><span class=\"wikibase-toolbar-item wikibase-toolbar " +
            "\">[<span class=\"wikibase-toolbar-item wikibase-toolbar-button wikibase-toolbar-button-edit\"><a href=\"/wiki/Special:SetSiteLink/Q170596\">edit</a></span>]</span></span>";

        Matcher m = p.matcher(line);
        if (m.matches()) {
            String first_part = m.group(1);
            System.out.println(first_part);
        }
    }
}