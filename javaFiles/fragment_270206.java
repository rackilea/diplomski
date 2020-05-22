public String toSafeHtml(String html) throws ScanException, PolicyException {

    Policy policy = Policy.getInstance(POLICY_FILE);
    AntiSamy antiSamy = new AntiSamy();
    CleanResults cleanResults = antiSamy.scan(html, policy);
    return cleanResults.getCleanHTML().trim();
}