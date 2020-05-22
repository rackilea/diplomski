Document doc = Jsoup.parse("<incident last-updated-dt='1401950400000' longitude='146.56256387822685' latitude='-38.39289894161029' resource-count='0' incident-no='58'>");
Element element = doc.select("incident").first();
String tagName = element.tagName();
System.out.println("Tag name : " + tagName);
for(Attribute attr : element.attributes())
{
    System.out.println(attr.getKey() + " : " + attr.getValue());
}