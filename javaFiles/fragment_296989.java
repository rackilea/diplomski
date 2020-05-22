public class CustomLogInInterceptor extends LoggingInInterceptor {

    private static final String MASK_PATTERN = "<\\s*{}\\s*>(.*)</\\s*{}\\s*>|<\\s*name\\s*>\\s*{}\\s*</\\s*name\\s*>\\s*<\\s*value\\s*>(.*)<";

    private Pattern pattern;

    private String[] keys;

    public void init() {
        StringBuilder builder = new StringBuilder();
        for (String str : keys) {
            builder.append(MASK_PATTERN.replace("{}", str));
            builder.append("|");
        }
        builder.setLength(builder.length()-1);
        pattern = Pattern.compile(builder.toString(), Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }


    @Override
    protected String formatLoggingMessage(LoggingMessage loggingMessage) {

        String output = maskPasswords(loggingMessage.toString());
        return(output);
    }


    private String maskPasswords(String str) {

        Matcher matcher = pattern.matcher(str);
        final StringBuilder builder = new StringBuilder(str);
        while (matcher.find()) {

            int group = 1;
            while (group <= matcher.groupCount()) {
                if (matcher.group(group) != null) {
                    for (int i = matcher.start(group); i < matcher.end(group); i++) {
                        builder.setCharAt(i, '*');
                    }
                }
                group++;
            }
        }
        return builder.toString();

    }

}