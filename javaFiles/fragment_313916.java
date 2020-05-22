import org.jdom.Attribute;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.Document;
import org.jdom.Element;

        Document document = new Document();
        Element html = new Element("html");            
        Element body = new Element("body");
        Element head = new Element("head");

        Element div = new Element("div");
        Attribute id = new Attribute("id", "dynamicdiv");
        Element moreElements = new Element("moreElements");

        document.setRootElement(html);

        div.addContent("");
        div.setAttribute(id)
        moreElements.addContent("");

        body.addContent(div);
        body.addContent(moreElements);
        html.addContent(head);
        html.addContent(body);