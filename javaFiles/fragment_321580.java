import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class AddXmlNode {
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("server.xml");
        Element root = document.getDocumentElement();

        Collection<Server> servers = new ArrayList<Server>();
        servers.add(new Server());

        for (Server server : servers) {
            // server elements
            Element newServer = document.createElement("server");

            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(server.getName()));
            newServer.appendChild(name);

            Element port = document.createElement("port");
            port.appendChild(document.createTextNode(Integer.toString(server.getPort())));
            newServer.appendChild(port);

            root.appendChild(newServer);
        }

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("server.xml");
        transformer.transform(source, result);
    }

    public static class Server {
        public String getName() { return "foo"; }
        public Integer getPort() { return 12345; }
    }
}