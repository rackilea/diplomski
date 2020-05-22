package XXXX.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

    public class XMLparser_ implements EntryPoint {

        public void onModuleLoad() {

            //a really simple XML sample
            final String xmlString = "<div><p>helle</p><p>World</p></div>";

            Document xml = XMLParser.parse(xmlString);

            //get the nodelist of the Document element can be more than one
            NodeList nodesRoot = xml.getChildNodes();
            for (int i = 0; i < nodesRoot.getLength(); i++) {
                Node node = nodesRoot.item(i);
                RootPanel.get().add(new Label(node.toString()));

                //get the childs of the first node
                NodeList nodesChild = node.getChildNodes();         
                for (int j = 0; j < nodesChild.getLength(); j++) {
                    Node node2 = nodesChild.item(j);
                    RootPanel.get().add(new Label(node2.toString()));
                }
            }

            SafeHtml safeHTML = new SafeHtml() {

                @Override
                public String asString() {
                    return xmlString;
                }
            };

            RootPanel.get().add(new HTML(safeHTML));

        }
    }