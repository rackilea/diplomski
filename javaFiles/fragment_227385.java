package forum9698306;

import javax.xml.bind.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;    
import org.w3c.dom.*;

public class JavaXML {

    public static void main(String[] args) throws Exception {
        Item item = new Item();

        JAXBContext jaxb = JAXBContext.newInstance(item.getClass().getPackage().getName());        
        Marshaller marshaller = jaxb.createMarshaller();
        item.setNote("Notetest1");
        item.setTitle("Title1");

        Category category = new Category();
        category.setStringOne("string1");
        category.setStringTwo("string2");
        item.setCategory(category);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        marshaller.marshal(item, doc);

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        System.out.println(xpath.evaluate("item/note/text()", doc, XPathConstants.STRING));
        System.out.println(xpath.evaluate("item/title/text()", doc, XPathConstants.STRING));
        System.out.println(xpath.evaluate("item/category/stringOne/text()", doc, XPathConstants.STRING));
        System.out.println(xpath.evaluate("item/category/stringTwo/text()", doc, XPathConstants.STRING));
    }

}