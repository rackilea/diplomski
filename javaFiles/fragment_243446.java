import java.io.*;
import java.nio.channels.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Test2{ 
    String path = "...Test 2.xml";

    public Test2(){
        Document doc = null;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        NodeList itemList;
        Transformer transformer;
        FileChannel channel; 
        Element newElement;
        int prevNumber;
        TransformerFactory transformerFactory ;
        DOMSource source;
        StreamResult result;
        NonClosingInputStream ncis = null;
        try {
            channel = new RandomAccessFile(new File(path), "rw").getChannel();
            FileLock lock = channel.lock(0L, Long.MAX_VALUE, false);

            try {
                dbFactory = DocumentBuilderFactory.newInstance();
                dBuilder = dbFactory.newDocumentBuilder();
                ncis = new NonClosingInputStream(Channels.newInputStream(channel));
                doc = dBuilder.parse(ncis);
            } catch (SAXException | IOException | ParserConfigurationException e) {
                e.printStackTrace();
            }
            doc.getDocumentElement().normalize();
            itemList = doc.getElementsByTagName("Item");
            newElement = doc.createElement("Item");
            prevNumber = Integer.parseInt(((Element) itemList.item(itemList.getLength() - 1)).getAttribute("Number"));
            newElement.setAttribute("Number", (prevNumber + 1) + "");

            doc.getDocumentElement().appendChild(newElement);

            transformerFactory = TransformerFactory.newInstance();
            transformer = transformerFactory.newTransformer();
            source = new DOMSource(doc);
            channel.truncate(0);
            result = new StreamResult(Channels.newOutputStream(channel));   

            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(source, result);
            channel.close();
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        } finally {
            try {
                ncis.reallyClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class NonClosingInputStream extends FilterInputStream {

        public NonClosingInputStream(InputStream it) {
            super(it);
        }

        @Override
        public void close() throws IOException {
            // Do nothing.
        }

        public void reallyClose() throws IOException {
            // Actually close.
            in.close();
        }
    }

    public static void main(String[] args){
        new Test2();
    }
}