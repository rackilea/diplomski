Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
NodeList l = d.getElementsByTagName("string");
for (int i = 0; i < l.getLength(); ++i) {
    if ("TestString".equals(l.item(i).getNodeValue())) {
        System.out.println(f.getAbsolutePath());
        break;
    }
}