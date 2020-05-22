import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringsToXmlConverter {

    private static final String SEPARTOR = "\\.";

    List<String> list;

    Map<String, XmlElement> elements = new HashMap<String,XmlElement>();

    public StringsToXmlConverter(List<String> list) {
        this.list = list;
    }

    public String getXml() {
        for (String xmlPaths: list) {
            String[] splitedElements = xmlPaths.split(SEPARTOR);
            XmlElement parent = null;
            for (String elem : splitedElements) {
                XmlElement currentElem = null;
                if (elements.containsKey(elem)) {
                    currentElem = elements.get(elem);
                    if (parent != null) {
                        addChild(parent, currentElem);
                    } 
                } else {
                    currentElem = createNewElement(parent, elem);
                    elements.put(elem, currentElem);
                }
                parent = currentElem;
            }
        }

        return buildXml().toString();
    }

    private void addChild(XmlElement parent, XmlElement currentElem) {
        currentElem.parent = parent;
        parent.childs.add(currentElem);
    }

    private XmlElement createNewElement(XmlElement parent, String name) {
        XmlElement currentElem;
        currentElem = new XmlElement();
        currentElem.name = name;
        if (parent != null) {
            addChild(parent, currentElem);
        }
        return currentElem;
    }

    private StringBuilder buildXml() {
        StringBuilder xml = new StringBuilder();
        for(XmlElement elem : elements.values()) {
            if (elem.parent == null) {
                xml.append(elem.toXml());
            }
        }
        return xml;
    }

    private class XmlElement {
        String name;
        Set<XmlElement> childs = new HashSet<XmlElement>();
        XmlElement parent = null;
        boolean isPrinted = false;

        private Set<XmlElement> getNoPrintedChilds() {
           Set<XmlElement> notPrintedChilds = new HashSet<XmlElement>();
           Iterator<XmlElement> iterator = childs.iterator();
           while(iterator.hasNext()) {
               XmlElement node = iterator.next();
               if (!node.isPrinted) {
                   notPrintedChilds.add(node);
               }
           }
           return notPrintedChilds;
        }

        public String toXml() {
           StringBuilder xml = new StringBuilder();
           if (!isPrinted) {
               xml.append("<" + name); 
               if (getNoPrintedChilds().isEmpty()) {
                xml.append("/>");
               } else {
                   xml.append(">");
                   for (XmlElement elem : getNoPrintedChilds()) {
                       xml.append(elem.toXml());
                   }
                   xml.append("</" + name + ">");
               }
           }
           isPrinted = true;
           return xml.toString();
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            XmlElement other = (XmlElement) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }
        private StringsToXmlConverter getOuterType() {
            return StringsToXmlConverter.this;
        }
    }

    public static void main(String[] args) {
        List<String> list= Arrays.asList("Alpha.Beta.Com", 
                                         "Alpha.Xeta.Hash", 
                                         "Alpha.Eta.Dot",
                                         "Alpha.Eta.Comma",
                                         "Alpha.Eta.Dollar",
                                         "Alpha.Xeta.Tilde");
        StringsToXmlConverter converter = new StringsToXmlConverter(list);
        System.out.println(converter.getXml());
    }


}