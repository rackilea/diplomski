public class CustomLogInInterceptor extends LoggingInInterceptor {

    @Override
    protected String formatLoggingMessage(LoggingMessage loggingMessage) {

        String str = loggingMessage.toString();

        String output = maskPasswords(str);
        return(output);
    }


    private String maskPasswords(String str) {

                final String[] keys = { "password", "passwords" };
                for (String key : keys) {
                    int beginIndex = 0;
                    int lastIndex = -1;
                    boolean emptyPass = false;
                    while (beginIndex != -1
                            && (beginIndex = StringUtils.indexOfIgnoreCase(str, key,
                                    beginIndex)) > 0) {

                        beginIndex = StringUtils.indexOf(str, ">", beginIndex);
                        if (beginIndex != -1) {
                            char ch = str.charAt(beginIndex - 1);
                            if (ch == '/') {
                                emptyPass = true;
                            }
                            if (!emptyPass) {
                                lastIndex = StringUtils.indexOf(str, "<", beginIndex);
                                if (lastIndex != -1) {
                                    String overlay = "*";
                                    String str2 = StringUtils.substring(str,
                                            beginIndex + 1, lastIndex);
                                    if (str2 != null && str2.length() > 1) {
                                        overlay = StringUtils.rightPad(overlay,
                                                str2.length(), "*");
                                        str = StringUtils.overlay(str, overlay,
                                                beginIndex + 1, lastIndex);
                                    }
                                }
                            }
                            if (emptyPass) {
                                emptyPass = false;
                                lastIndex = beginIndex + 1;
                            } else {
                                if (lastIndex != -1) {
                                    lastIndex = StringUtils
                                            .indexOf(str, ">", lastIndex);
                                }
                            }
                        }
                        beginIndex = lastIndex;
                    }
                }
                return str;

            }

}