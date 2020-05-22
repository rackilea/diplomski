public class JEPTest {
    public static class StringPropRadioButton
    extends JRadioButton {
        private static final long serialVersionUID = 1;

        public String getEnabledAsString() {
            return String.valueOf(isEnabled());
        }

        public void setEnabledAsString(String enabled) {
            setEnabled(Boolean.parseBoolean(enabled));
        }
    }

    public static void main(String[] args) throws Exception{
        String data = "<html>\n" +
        "\n" +
        "<body>\n" +
        "<input type='radio' disabled>\n" +
        "\n" +
        "<p>" +
            "<object classid='JEPTest$StringPropRadioButton' id='option1'>" +
            "    <param name='text' value='Option 1'>" +
            "    <param name='enabledAsString' value='false'>" +
            "</object>" +
        "</body>\n" +
        "</html>";