public static String inputXmlXPathParser(String inputXml){


        //==================================================X-Path Parser =============================================================//

        String transactionName = StringUtils.EMPTY;

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(true);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource( new StringReader(inputXml)));
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expression = xpath.compile("/Service/Inquiry/InquiryType/text()");
            NodeList xpathNodeList = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
            System.out.println("InquiryType is : " +xpathNodeList.item(0));

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    


        return transactionName;

    }