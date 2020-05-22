@Test
public void testCSSParser2() throws IOException {
    String css = "@media only screen and (max-width: 600px) {body { background-color: lightblue } h1 { color: red } }";
    InputSource source = new InputSource(new StringReader(css));
    CSSOMParser parser = new CSSOMParser(new SACParserCSS3());
    CSSStyleSheet sheet = parser.parseStyleSheet(source, null, null);
    CSSRuleList rules = sheet.getCssRules();
    for (int x = 0; x < rules.getLength(); x++) {
        final CSSMediaRule mediaRule = ((CSSMediaRule) rules.item(x));
        CSSRuleList mediaRules = mediaRule.getCssRules();
        for (int y = 0; y < mediaRules.getLength(); y++) {
            final CSSRule rule = mediaRules.item(y);
            System.out.println(rule.getCssText());

        }
    }

}