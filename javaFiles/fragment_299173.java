Element element = doc.getElementById("122"); // null
        //System.out.println(element.getNodeValue());
        NodeList e = doc.getElementsByTagName("myxml");
        NamedNodeMap namedNodeMap = e.item(0).getAttributes();
        String value = namedNodeMap.getNamedItem("id").getNodeValue();
        System.out.println(value); // 122