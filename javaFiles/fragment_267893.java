public static void mainv1(String[] args) {

    File file = new File("C:\\test.xml");
    File outputFile = new File("C:\\test.csv");

    BufferedWriter bw = null;

    try {
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(file);

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        // Open in try because FileWriter constructor throws IOException
        bw = new BufferedWriter(new FileWriter(outputFile));

        if (doc.hasChildNodes()) {
            printNote(doc.getChildNodes(), bw);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    } finally {
        // Check for null because bw won't be initialized if document parsing failed
        if (bw != null) {
            try {
                bw.close();
            } catch (final IOException e) {
                // Log error
            }
        }
    }
}