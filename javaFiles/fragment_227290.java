try {
    Document document = builder.parse(
            new FileInputStream("data\\text.xml"));
} catch (SAXException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}