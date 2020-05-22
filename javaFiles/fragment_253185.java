SAXBuilder builder = new SAXBuilder();
        Document xml_document = builder.build(new File(getServletContext().getRealPath("/") + XML_FILE));

        // Get root element
        Element root = xml_document.getRootElement();

        // Create a list of the children of the root element
        List<Element> kids = root.getChildren();

        // Interate through list of elements and delete (detach) the element at position index.
        int i = 1;
        for (Element element : kids)
        {
            if(i == index)
            {
                element.detach();
                break;
            }
            else
            {
            i = i + 1;
            }               
        }