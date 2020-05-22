public class XMLSkipResumeFilter extends XMLFilterImpl {
    private boolean skipCurrentTag = false;
    private Set resumeIdsToLeave;

    public XMLSkipResumeFilter(XMLReader parent, Set resumeIdsToLeave) {
        super(parent);

        this.resumeIdsToLeave = resumeIdsToLeave;
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        // analyze if current tag should be skipped or check if parent tag is already marked as skipped
        // if (...) { return; }
        // if this resume should be rendered calling to super method
        // if (...) { super.startElement(uri, localName, qName, atts); }
    }

    //implements other method of XMLFilterImpl
}