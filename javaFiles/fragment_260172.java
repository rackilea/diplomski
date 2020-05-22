public class MainFrame {

    private static final String emailString = "Jhon, N, Edward, <edward@sri.lk>, " + "Mickal, Lantz, <mickal@sri.lk>, " + "Thomas, F, Kevin, <kevin@sri.lk>, " + "Marina, Anderson, <marina@sri.lk>, " + "Henry, Ford, <ford@sri.lk>, " + "Davin, Cammeron, <Cammeron@sri.lk>";

    /**
     * @param args
     */
    public static void main(String[] args) {
        String EMAIL_PATTERN = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";

        String regularExpression = "(.*?<)" + EMAIL_PATTERN + "(>,)";
        Pattern pattern = Pattern.compile(regularExpression);

        Matcher matcher = pattern.matcher(emailString);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}