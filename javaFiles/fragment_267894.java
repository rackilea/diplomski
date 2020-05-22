public static void main(String[] args) {

    File file = new File("C:\\test.xml");
    File outputFile = new File("C:\\test.csv");

    // Since Java7 you can use try-with-resources
    // The finally block closing the writer will be created automatically
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        if (doc.hasChildNodes()) {
            printNote(doc.getChildNodes(), bw);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}