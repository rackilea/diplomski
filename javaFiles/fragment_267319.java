import org.dom4j.*;

String text = "<xml><name>oscar</name><race>puppet</race><class>grouch</class></xml>";
Document document = DocumentHelper.parseText(text);
Element root = document.getRootElement();

for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
    Element element = (Element) i.next();
    String tagName = element.getQName();
    String contents = element.getText();
    // do something
}