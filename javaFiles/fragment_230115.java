public Map<String, CSSStyleRule> parseCSS() throws IOException {
    Map<String, CSSStyleRule> rules = new HashMap<String, CSSStyleRule>();

    InputSource inputSource = new InputSource(new FileReader("bootstrap.css"));
    CSSStyleSheet styleSheet = new CSSOMParser().parseStyleSheet(inputSource, null, null);

    CSSRuleList ruleList = styleSheet.getCssRules();
    for (int i = 0; i < ruleList.getLength(); i++) {
        CSSRule rule = ruleList.item(i);
        if (rule.getType() == CSSRule.STYLE_RULE) {
            CSSStyleRule styleRule = (CSSStyleRule) rule;
            rules.put(styleRule.getSelectorText(), styleRule);
        }
    }

    return rules;
}