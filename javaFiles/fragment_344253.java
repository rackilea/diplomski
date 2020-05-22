private String[] elements;

    public Map<String, Object> xPathParser(String xmlString) {
        try {
            Document xmlDoc = xmlStringToDocument(xmlString);

            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression;
            Map<String, Object> elements = new HashMap<>();
            for (String element : elements) {
                expression = MessageFormat.format("//{0}/text()", element);

                Object xpathValue = xpath.compile(expression).evaluate(xmlDoc, XPathConstants.STRING);

                elements.put(element, xpathValue);
            }

            return elements;

        } catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException e) {
            LOGGER.error(e.toString());
            return null;
        }
    }