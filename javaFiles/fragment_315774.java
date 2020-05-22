import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;


public class MyHandler extends DefaultHandler {
private List<Entry> wordList = null;
private Entry word = null;

public List<Entry> getwordList() {
return wordList;
}

boolean bword = false;

@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("entry")) {
    String id = attributes.getValue("id");
    word = new Entry();
    word.setID(Integer.parseInt(id));
    if (wordList == null) 
        wordList = new ArrayList<>();
    } else if (qName.equalsIgnoreCase("word")) {
        bword = true;
    }
}


@Override
public void endElement(String uri, String localName, String qName) throws SAXException {
if (qName.equalsIgnoreCase("entry")) {
    wordList.add(word);
}
}

@Override
public void characters(char ch[], int start, int length) throws SAXException {
if (bword) {
    word.setWord(new String(ch, start, length));
    bword = false;
    }
   }

}