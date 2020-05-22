NodeList configTags = doc.getElementsByTagName("Config");
// assuming there will only be one `Config` node
NodeList elements = configTags.item(0).getChildNodes();

for (int i = 0; i < elements.getLength(); i++) {
   // (everything else looks correct)...
}