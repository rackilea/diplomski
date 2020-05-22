for (int j = 0; j <= children.getLength(); j++) {
    if(children.item(j) != null ) {
            if (children.item(j).getNodeName().equalsIgnoreCase("directory"))
                    children.item(j).setTextContent("D:\\Logs");
    }
}