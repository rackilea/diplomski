String srec = "";
            NodeList nl = line.getChildNodes();
            srec += nl.item(0).getTextContent();

            Node n = nl.item(1);
            NamedNodeMap nm = n.getAttributes();
            srec += "<a href=\"" + nm.getNamedItem("href").getTextContent() +  "\">" + n.getTextContent() + "</a>";

            srec += nl.item(2).getTextContent();

            String[c1] = srec;