String cleanXmlAndRemoveUnwantedTags(String textToEscape) {
    Whitelist whitelist = Whitelist.none();
    whitelist.addTags(allowedTags);

    OutputSettings outputSettings = new OutputSettings()
                    .syntax(OutputSettings.Syntax.xml)
                    .charset(StandardCharsets.UTF_8)
                    .prettyPrint(false);

    String safe = Jsoup.clean(textToEscape, "", whitelist, outputSettings);
    return safe;
}