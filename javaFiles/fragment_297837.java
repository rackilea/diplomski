public class MyHandler extends DefaultHandler {

    // Use a DEQUE to track the current position inthe xml.
    private Deque<String> position = new ArrayDeque<>();
    // My data.
    private StringBuilder data = new StringBuilder();

    private String element = null;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (match()) {
            // Append to my buffer.
            data.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Ending a tag - pop it from end.
        position.removeLast();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Starting a tag - push it at the end.
        position.addLast(qName);
    }

    public String getElement() {
        return this.element;
    }

    // Specifically looking for the REQUEST.ELEMENT - not the REQUEST.LIST.ELEMENT
    private final String[] lookingFor = {"REQUEST", "ELEMENT"};

    private boolean match() {
        // Must be that deep.
        if (position.size() == lookingFor.length) {
            // Must match.
            Iterator<String> match = position.iterator();
            for (int i = 0; i < lookingFor.length; i++) {
                // Match?
                if (!match.next().equals(lookingFor[i])) {
                    return false;
                }
            }
        } else {
            // Wrong depth.
            return false;
        }
        // No mismatch -> match!
        return true;
    }

}