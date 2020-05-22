....
ArrayList<String> attributeList;
for (int i = 0; i < attribute.getLength(); i++) {
    String current = attribute.item(i).getTextContent();
    if (current.equals("Identifier")) {
        largeAttributeList.add(attributeList);
        attributeList = new ArrayList<>();//<<<-------------
    } else {
        attributeList.add(current);
    }

}