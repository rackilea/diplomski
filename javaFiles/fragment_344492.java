public class VDispatch extends DefaultHandler {
     private DefaultHandler current_;
     private int subtreeLevel_;

     public void startElement(String uri, String localName, String qName, Attributes attributes) {
          if ((current_ == null) && (subtree-is-starting)) {
              current_ = select-handler-based-on-xsd;
              subtreeLevel_ = 0;
          }
          if (current_ != null) {
              current_.startElement(uri, localName, qName, attributes);
              subtreeLevel_++;
          }
     }

     public void endElement(String uri, String localName, String qName) {
          if (current_ != null) {
              current_.endElement(uri, localName, qName);
              if (--subtreeLevel_ == 0)
                  current_ = null;
          }
     }

     // simple forwarding in all other DefaultHandler methods
     public void characters(char[] ch, int start, int length) {
          if (current_ != null)
              current_.characters(ch, start, length);
     }
}