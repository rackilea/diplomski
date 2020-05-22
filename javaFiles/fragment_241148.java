@Test
public void verifyInvalidCharsOnMessages() throws IOException {
    verifyInvalidChars("src/main/resources/i18n/messages.properties");
    verifyInvalidChars("src/main/resources/i18n/messages_pt_BR.properties");
}

private void verifyInvalidChars(String file) throws IOException {
    Properties p = new Properties();
    FileInputStream input = new FileInputStream(new File(file));
    p.load(new InputStreamReader(input, Charset.forName("UTF-8")));

    Enumeration<String> enums = (Enumeration<String>) p.propertyNames();
    while (enums.hasMoreElements()) {
        String key = enums.nextElement();
        String value = p.getProperty(key);
        if (value.indexOf('\uFFFD') > 0) {
            fail();
        }
    }

}