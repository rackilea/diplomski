class Handler extends DefaultHandler {

String currentElement;
String currentAgeValue;
String currentNameValue;

@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    super.startElement(uri, localName, qName, attributes);
    currentElement = qName;
}

@Override
public void characters(char[] ch, int start, int length) throws SAXException {
    super.characters(ch, start, length);
    switch(currentElement) {
        case "age":
        currentAgeValue = new String(ch, start, length);
        break;
        case "name":
        currentNameValue = new String(ch, start, length);
        break;
    }
}

@Override
public void endElement(String uri, String localName, String qName) throws SAXException {
    super.endElement(uri, localName, qName);
    if(qName.equals("employees")) {
        int age = Integer.parseInt(currentAgeValue);
        if(age > 30) { 
            System.out.println("Name:" + currentNameValue+", Age:" + age);
        }
    }
}

public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    String xml = "<company><name>CompanyName</name><employees id=\"0\"><name>employee name0</name><age>33</age><role>tester</role><gen>male</gen></employees><employees id=\"1\"><name>employee name1</name><age>18</age><role>tester</role><gen>female</gen></employees><employees id=\"2\"><name>employee name2</name><age>38</age><role>developer</role><gen>male</gen></employees></company>";
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();
    saxParser.parse(new InputSource(new StringReader(xml)), new Handler());
}