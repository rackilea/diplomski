public void go() {
    try {
        XMLReader reader = getXMLReader();
        reader.parse(new InputSource(new FileInputStream(new File(FILE))));
    } catch (Exception ex) {
        throw new RuntimeException("The most epic fail.", ex);
    }
}