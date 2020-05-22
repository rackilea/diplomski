import com.google.common.collect.LinkedHashMultimap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class App {

    public static void main(String[] args) throws SAXException, FileNotFoundException, IOException {
        // First pass - to determine headers
        XMLReader xr = XMLReaderFactory.createXMLReader();
        HeaderHandler handler = new HeaderHandler();
        xr.setContentHandler(handler);
        xr.setErrorHandler(handler);
        FileReader r = new FileReader("test1.xml");
        xr.parse(new InputSource(r));

        LinkedHashMap<String, Integer> headers = handler.getHeaders();
        int totalnumberofcolumns = 0;
        for (int headercount : headers.values()) {
            totalnumberofcolumns += headercount;
        }
        String[] columnheaders = new String[totalnumberofcolumns];
        int i = 0;
        for (Entry<String, Integer> entry : headers.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                columnheaders[i] = entry.getKey();
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String h : columnheaders) {
            sb.append(h);
            sb.append(',');
        }
        System.out.println(sb.substring(0, sb.length() - 1));

        // Second pass - collect and output data

        xr = XMLReaderFactory.createXMLReader();

        DataHandler datahandler = new DataHandler();
        datahandler.setHeaderArray(columnheaders);

        xr.setContentHandler(datahandler);
        xr.setErrorHandler(datahandler);
        r = new FileReader("test1.xml");
        xr.parse(new InputSource(r));
    }

    public static class HeaderHandler extends DefaultHandler {

        private String content;
        private String currentElement;
        private boolean insideElement = false;
        private Attributes attribs;
        private LinkedHashMap<String, Integer> itemHeader;
        private LinkedHashMap<String, Integer> accumulativeHeader = new LinkedHashMap<String, Integer>();

        public HeaderHandler() {
            super();
        }

        private LinkedHashMap<String, Integer> getHeaders() {
            return accumulativeHeader;
        }

        private void addItemHeader(String headerName) {
            if (itemHeader.containsKey(headerName)) {
                itemHeader.put(headerName, itemHeader.get(headerName) + 1);
            } else {
                itemHeader.put(headerName, 1);
            }
        }

        @Override
        public void startElement(String uri, String name,
                String qName, Attributes atts) {
            if ("item".equalsIgnoreCase(qName)) {
                itemHeader = new LinkedHashMap<String, Integer>();
            }
            currentElement = qName;
            content = null;
            insideElement = true;
            attribs = atts;
        }

        @Override
        public void endElement(String uri, String name, String qName) {
            if (!"item".equalsIgnoreCase(qName) && !"root".equalsIgnoreCase(qName)) {
                if (content != null && qName.equals(currentElement) && content.trim().length() > 0) {
                    addItemHeader(qName);
                }
                if (attribs != null) {
                    int attsLength = attribs.getLength();
                    if (attsLength > 0) {
                        for (int i = 0; i < attsLength; i++) {
                            String attName = attribs.getLocalName(i);
                            addItemHeader(attName);
                        }
                    }
                }
            }
            if ("item".equalsIgnoreCase(qName)) {
                for (Entry<String, Integer> entry : itemHeader.entrySet()) {
                    String headerName = entry.getKey();
                    Integer count = entry.getValue();
                    //System.out.println(entry.getKey() + ":" + entry.getValue());
                    if (accumulativeHeader.containsKey(headerName)) {
                        if (count > accumulativeHeader.get(headerName)) {
                            accumulativeHeader.put(headerName, count);
                        }
                    } else {
                        accumulativeHeader.put(headerName, count);
                    }
                }
            }
            insideElement = false;
            currentElement = null;
            attribs = null;
        }

        @Override
        public void characters(char ch[], int start, int length) {
            if (insideElement) {
                content = new String(ch, start, length);
            }
        }
    }

    public static class DataHandler extends DefaultHandler {

        private String content;
        private String currentElement;
        private boolean insideElement = false;
        private Attributes attribs;
        private LinkedHashMultimap dataMap;
        private String[] headerArray;

        public DataHandler() {
            super();
        }

        @Override
        public void startElement(String uri, String name,
                String qName, Attributes atts) {
            if ("item".equalsIgnoreCase(qName)) {
                dataMap = LinkedHashMultimap.create();
            }
            currentElement = qName;
            content = null;
            insideElement = true;
            attribs = atts;
        }

        @Override
        public void endElement(String uri, String name, String qName) {
            if (!"item".equalsIgnoreCase(qName) && !"root".equalsIgnoreCase(qName)) {
                if (content != null && qName.equals(currentElement) && content.trim().length() > 0) {
                    dataMap.put(qName, content);
                }
                if (attribs != null) {
                    int attsLength = attribs.getLength();
                    if (attsLength > 0) {
                        for (int i = 0; i < attsLength; i++) {
                            String attName = attribs.getLocalName(i);
                            dataMap.put(attName, attribs.getValue(i));
                        }
                    }
                }
            }
            if ("item".equalsIgnoreCase(qName)) {
                String data[] = new String[headerArray.length];
                int i = 0;
                for (String h : headerArray) {
                    if (dataMap.containsKey(h)) {
                        Object[] values = dataMap.get(h).toArray();
                        data[i] = (String) values[0];
                        if (values.length > 1) {
                            dataMap.removeAll(h);
                            for (int j = 1; j < values.length; j++) {
                                dataMap.put(h, values[j]);
                            }
                        } else {
                            dataMap.removeAll(h);
                        }
                    } else {
                        data[i] = "";
                    }
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                for (String d : data) {
                    sb.append(d);
                    sb.append(',');
                }
                System.out.println(sb.substring(0, sb.length() - 1));
            }
            insideElement = false;
            currentElement = null;
            attribs = null;
        }

        @Override
        public void characters(char ch[], int start, int length) {
            if (insideElement) {
                content = new String(ch, start, length);
            }
        }

        public void setHeaderArray(String[] headerArray) {
            this.headerArray = headerArray;
        }
    }
}