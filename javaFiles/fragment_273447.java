public enum MaskSensitiveData {

    CURRENT_PASSWORD("(current[_\\s-]password)[=:\"\\s]*(\\w*)"),

    PASSWORD("[&,;\"\'\\s]+(password|pwd)[=:\"\\s]*(\\w*)"),

    PASSWORD_CONFIRMATION("(password[_\\s-]confirmation)[=:\"\\s]*(\\w*)"),

    API_KEY("(api[_\\s-]key)[=:\"\\s]*(\\w*)"),

    RESET_PASSWORD_TOKEN("(reset[_\\s-]password[_\\s-]token)[=:\"\\s]*(\\w*)"),

    UPLOAD_TOKEN("(upload[_\\s-]token)[=:\"\\s]*(\\w*)"),

    AUTH_TOKEN("(auth[_\\s-]token)[=:\"\\s]*(\\w*)");

    private String regEx;

     MaskSensitiveData(String exp) {
        regEx = exp;
    }

    public String getRegEx() {
        return regEx;
    }
}

String message = event.getRenderedMessage();
StringBuffer sb = new StringBuffer(message);
for (MaskSensitiveData sensitiveData : MaskSensitiveData.values()) {
    Pattern PATTERNCARD = Pattern.compile(sensitiveData.getRegEx(), Pattern.CASE_INSENSITIVE);
    Matcher matcher = PATTERNCARD.matcher(message);
        if (matcher.find()) {
            String maskedMessage = matcher.group(2);
            message = message.replaceFirst(maskedMessage, MASKCARD);