// Read file
    InputSource inputStream = new InputSource(new FileInputStream(inputFileName));

    // Find the task node
    XPath xpath = XPathFactory.newInstance().newXPath();
    Node taskNode = (Node)xpath.evaluate("//task[uuid='92F7F685-C370-4E55-9026-020E3CDCEDE0']", inputStream,
            XPathConstants.NODE);
    Document document = taskNode.getOwnerDocument();
    // Insert a new node
    Node noteNode = document.createElement("task_note");
    noteNode.setTextContent("this is a note");
    taskNode.appendChild(noteNode);

    // Save file
    Source input = new DOMSource(document);
    Result output = new StreamResult(new File(outputFileName));
    TransformerFactory.newInstance().newTransformer().transform(input, output);