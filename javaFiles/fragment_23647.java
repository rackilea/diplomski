import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.sun.org.apache.xpath.internal.XPathAPI;

public static void main(String[] args) throws Exception {

    Document docFile1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("File1.xml"));
    Document docFileList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("FileList.xml"));
    NodeList result = XPathAPI.selectNodeList(docFile1.getFirstChild(), ".//Information");
    Node importNode = docFileList.importNode(result.item(0), true);  
    // We want to replace aCopy fruit with the updated version found in File1  
    NodeList fruitNode = XPathAPI.selectNodeList(docFileList.getFirstChild(), ".//aCopy[@name=\"fruit\"]");
    Node replaceNode = fruitNode.item(0).getParentNode().replaceChild(importNode, fruitNode.item(0)); // probably a better way to do this  
    // Now we want to replace the Element name as it is still set to Information  
    docFileList.renameNode(replaceNode, null, "aCopy"); 

    print(docFileList);

}