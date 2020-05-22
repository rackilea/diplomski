package com.example.rssapplication;

  import java.util.ArrayList;
  import java.util.List;

  import org.xml.sax.Attributes;
  import org.xml.sax.SAXException;
  import org.xml.sax.helpers.DefaultHandler;

  import android.util.Log;

  /**
   * SAX tag handler
   * 
   * @author ITCuties
   *
   */
 public class RssParseHandler extends DefaultHandler {

 private List<RssItem> rssItems;

// Used to reference item while parsing
private RssItem currentItem;

// Parsing title indicator
private boolean parsingTitle;
// Parsing link indicator
private boolean parsingLink;
String strTitle = "";

public RssParseHandler() {
    rssItems = new ArrayList<RssItem>();
    //RssItem g = null;
    //rssItems.add(g);
}

public List<RssItem> getItems() {
    return rssItems;
}

@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if ("item".equals(qName)) {
        currentItem = new RssItem();
    } else if ("title".equals(qName)) {
        parsingTitle = true;            
    } else if ("link".equals(qName)) {
        parsingLink = true;
    }
}

@Override
public void endElement(String uri, String localName, String qName) throws SAXException {
    if ("item".equals(qName)) {
        rssItems.add(currentItem);
        currentItem = null;
    } else if ("title".equals(qName)) {
        parsingTitle = false;
        strTitle = "";
    } else if ("link".equals(qName)) {
        parsingLink = false;
    }
}

@Override
public void characters(char[] ch, int start, int length) throws SAXException {

    if (parsingTitle) {
        if (currentItem != null)
        {
            strTitle = strTitle
                    + (String) new String(ch, start, length).toString();

            currentItem.setTitle(strTitle);       
        }
    } else if (parsingLink) {
        if (currentItem != null) {
            currentItem.setLink(new String(ch, start, length));
            parsingLink = false;
        }
    }
 }

}