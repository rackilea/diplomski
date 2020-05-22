Elements hrefElements = doc.select("div.bmatch");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        org.w3c.dom.Document doc1 = docBuilder.newDocument();
        org.w3c.dom.Element rootElement = doc1.createElement("company");
        doc1.appendChild(rootElement);


        for( int i = 0; i < hrefElements.size(); i++ ) 
        {
            // staff elements
            org.w3c.dom.Element staff = doc1.createElement("Event");
            rootElement.appendChild(staff);

            // set attribute to staff element
            Attr attr = doc1.createAttribute("id");
            attr.setValue("" + (i + 1));
            staff.setAttributeNode(attr);

            Element timeSection = hrefElements.get(i).select("div.mtime").first(); // one time section
            Element teamsSection = hrefElements.get(i).select("div.mteams").first(); // one team section
            Element infoSection = hrefElements.get(i).select("div.minfo").first(); // one info section

            String time = timeSection.text();
            Elements teams = teamsSection.select("div.team"); // many teams within team section
            String tvInfo = infoSection.select("div.tv").first().attr("data-tvinfo");

            // time element
            org.w3c.dom.Element timeElement = doc1.createElement("Time");
            timeElement.appendChild(doc1.createTextNode(time));
            staff.appendChild(timeElement);
            System.out.println(timeElement.getTextContent());

            // teams
            for(int j = 0; j < teams.size(); j++) {
                org.w3c.dom.Element teamElement = doc1.createElement("Team" + (j + 1));
                teamElement.appendChild(doc1.createTextNode(teams.get(j).text()));
                staff.appendChild(teamElement);
                System.out.println(teamElement.getTextContent());
            }

            // tv info
            org.w3c.dom.Element nickname = doc1.createElement("TV");
            nickname.appendChild(doc1.createTextNode(tvInfo));
            staff.appendChild(nickname);
            System.out.println(nickname.getTextContent());
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc1);

        StreamResult result = new StreamResult(new File("test.xml"));
        transformer.transform(source, result);

        System.out.println("File saved!");