NodeList application = doc.getElementsByTagName("application");
for (int i = 0; i < application.getLength(); i++) {
  Element applicationElement = (Element) application.item(i);
  NodeList interfaces = applicationElement.getElementsByTagName("interface");
  for (int j = 0; j < interfaces.getLength(); j++) {
    do some stuff...
  }
}