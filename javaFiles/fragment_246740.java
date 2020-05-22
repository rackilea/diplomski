ArrayList<ChapterNode> chapters = new ArrayList<ChapterNode>();
ChapterNode chapterNode = null;

public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
    if(localName.equals("chapters")) {
    } else if(localName.equals("chapter")) {
        chapterNode = new ChapterNode();
        chapterNode.title = atts.getValue("title");
    } else if(localName.equals("page")) {
        PageNode pageNode = new PageNode();
        pageNode.title = atts.getValue("title");
        pageNode.url = atts.getValue("url");
        chapterNode.pages.add(pageNode);
    }
}

@Override
public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
    if(localName.equals("chapters")) {
    } else if(localName.equals("chapter")) {
        chapters.add(chapterNode);
        chapterNode = null;
    } else if(localName.equals("page")) {
    }
}