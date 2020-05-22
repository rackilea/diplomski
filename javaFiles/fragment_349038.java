//Build the document from the xmlString
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new InputSource(new StringReader(xmlString)));

    //Get all the transaction elements and then loop over them
    NodeList transaction = doc.getElementsByTagName("transaction");
    for(int j = 0; j < transaction.getLength(); j++) {
        //Traverse down the transaction node till we get the billing info
        NodeList details = ((Element)transaction.item(j)).getElementsByTagName("details");
        NodeList account = ((Element)details.item(0)).getElementsByTagName("account");
        NodeList billinginfo = ((Element)account.item(0)).getElementsByTagName("billing_info");

        System.out.println("===Billing Info===");
        System.out.println("Type: "+((Element)billinginfo.item(0)).getAttribute("type"));

        //Get all children nodes from billing info
        NodeList billingChildren = billinginfo.item(0).getChildNodes();

        for(int i = 0; i < billingChildren.getLength(); i++) {
            Node current = billingChildren.item(i);
            //Only want stuff from ELEMENT nodes
            if(current.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(current.getNodeName()+": "+current.getTextContent());
            }
        }
    }