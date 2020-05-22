List<String> headers = new ArrayList<String>(5);

File file = new File("Names2.csv");
BufferedReader reader = null;

try {

    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder domBuilder = domFactory.newDocumentBuilder();

    Document newDoc = domBuilder.newDocument();
    // Root element
    Element rootElement = newDoc.createElement("XMLCreators");
    newDoc.appendChild(rootElement);

    reader = new BufferedReader(new FileReader(file));
    int line = 0;

    String text = null;
    while ((text = reader.readLine()) != null) {

        StringTokenizer st = new StringTokenizer(text, " ", false);    
        String[] rowValues = new String[st.countTokens()];
        int index = 0;
        while (st.hasMoreTokens()) {

            String next = st.nextToken();
            rowValues[index++] = next;

        }

        //String[] rowValues = text.split(",");

        if (line == 0) { // Header row
            for (String col : rowValues) {
                headers.add(col);
            }
        } else { // Data row
            Element rowElement = newDoc.createElement("row");
            rootElement.appendChild(rowElement);
            for (int col = 0; col < headers.size(); col++) {
                String header = headers.get(col);
                String value = null;

                if (col < rowValues.length) {
                    value = rowValues[col];
                } else {
                    // ?? Default value
                    value = "";
                }

                Element curElement = newDoc.createElement(header);
                curElement.appendChild(newDoc.createTextNode(value));
                rowElement.appendChild(curElement);
            }
        }
        line++;
    }

    ByteArrayOutputStream baos = null;
    OutputStreamWriter osw = null;

    try {
        baos = new ByteArrayOutputStream();
        osw = new OutputStreamWriter(baos);

        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
        aTransformer.setOutputProperty(OutputKeys.METHOD, "xml");
        aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        Source src = new DOMSource(newDoc);
        Result result = new StreamResult(osw);
        aTransformer.transform(src, result);

        osw.flush();
        System.out.println(new String(baos.toByteArray()));
    } catch (Exception exp) {
        exp.printStackTrace();
    } finally {
        try {
            osw.close();
        } catch (Exception e) {
        }
        try {
            baos.close();
        } catch (Exception e) {
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}