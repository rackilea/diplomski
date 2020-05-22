List<Transfer> list = new ArrayList<Transfer>();
NodeList nodelist = document.getElementsByTagName("transfer");

for (int i=0; i<nodelist.getLength(); i++) {
    Element element = (Element) nodelist.item(i);

    if (isValidTransfer(element) {
        Transfer t = buildTransferFromElement(element);
        list.add(t);
    }
}