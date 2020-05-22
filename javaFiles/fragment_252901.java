// Comma separated list of allowed tags.
private static String ALLOWED_HTML_TAGS_CSS_QUERY = "b,span";

private static String limitHtml(String value) {
    String result = value;
    if (value != null && !value.isEmpty()) {
        // Build a sided document. It will help us escape unallowed tags. 
        Document transitional = Jsoup.parse("<pre></pre>");

        // Parse the actual value for finding unallowed tags
        Document doc = Jsoup.parseBodyFragment(value, "");
        Elements unallowedElements = doc.select("*:not("+ALLOWED_HTML_TAGS_CSS_QUERY+")");

        for (Element e : unallowedElements) {
            switch (e.tagName()) {
            case "#root": case "html": case "head": case "body":
                // Those tags are added automatically by Jsoup. Nothing to do...
                break;

            default:
                // Load the unallowed element to escape its html code in the transitional document
                Element pre = transitional.select("pre").first().text(e.outerHtml());

                // Replace unallowed element with its escape html code
                e.replaceWith(new TextNode(pre.text(), ""));
            }
        }

        // Get the final sanitized value
        Document.OutputSettings settings = new Document.OutputSettings();
        settings.prettyPrint(false);

        Whitelist whitelist = Whitelist.none().addTags(ALLOWED_HTML_TAGS);
        whitelist.addAttributes(":all", ALLOWED_HTML_ATTRIBUTES);
        result = Jsoup.clean(doc.body().html(), "", whitelist, settings);
    }

    return result;
}