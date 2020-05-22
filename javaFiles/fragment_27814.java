class IdsXmlAdapter extends XmlAdapter<Object, MultiItemList> {

    @Override
    public MultiItemList unmarshal(Object v) {
        Element element = (Element) v;
        NodeList childNodes = element.getChildNodes();
        List<String> ids = new ArrayList<>(childNodes.getLength());
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeName().equals("#text")) {
                continue;
            }
            ids.add(item.getTextContent());
        }

        MultiItemList multiItemList = new MultiItemList();
        multiItemList.setIds(ids);
        return multiItemList;
    }

    @Override
    public Object marshal(MultiItemList v) throws Exception {
        return null; // Implement if needed
    }
}