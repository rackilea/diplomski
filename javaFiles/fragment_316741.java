// Parse my XML doc using a DOM parser
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(source);

// Get all descendant elements `primary-class`
NodeList nl = doc.getElementsByTagName("primary-class");

// Initialize my lists 
int length = nl.getLength();
List<String> superClasses = new ArrayList<>(length);
List<String> subClasses = new ArrayList<>(length);

// For each element `primary-class` found
for (int i = 0; i < nl.getLength(); i++){
    Element element = (Element) nl.item(i);

    // Add the super class to the list
    NodeList nlSuperClasses = element.getElementsByTagName("super-class");
    superClasses.add(((Element) nlSuperClasses.item(0)).getAttribute("super-class"));

    // Add the sub class to the list if it exists, null otherwise
    NodeList nlSubClasses = element.getElementsByTagName("sub-class");
    subClasses.add(
        nlSubClasses.getLength() > 0 ? 
       ((Element) nlSubClasses.item(0)).getAttribute("sub-class") : 
       null
    );
}