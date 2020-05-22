package org.combobox;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.IOException;
import java.io.StringReader;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ComboBoxChain extends JFrame {
  private static final long serialVersionUID = 1L;
  private static String _xml;
    private Node _root;
    private CleanNode _cleanNode;

  public ComboBoxChain() throws ParserConfigurationException, SAXException, IOException {
    super("ComboBox Chain");
    setUIFont (new javax.swing.plaf.FontUIResource("Monospaced",Font.PLAIN,14));
    buildXML();
    cleanXML();
    _root = parse(_xml);
    _cleanNode = new CleanNode(_root);
    addCleanNodeChildren(_cleanNode, _root);

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    getContentPane().add(new ComboPanel(_cleanNode), BorderLayout.CENTER);
    pack();
    setResizable(false);
    setLocationRelativeTo(null);
  }

  private void addCleanNodeChildren(CleanNode cleanNode, Node node) {
    if(node.getChildNodes() != null) {
        NodeList children = node.getChildNodes();
      for(int index = 0; index < children.getLength(); index++){
        Node child = children.item(index);
        CleanNode cleanChild = cleanNode.addChild(child);
        addCleanNodeChildren(cleanChild, child);
      }
    }
  }

  protected Node getRootNode() {
    return _root;
  }

  private void cleanXML() {
    String xml = _xml;
    int beginIndex = -1;
    int endIndex = -1;

    for(int index = 0; index < _xml.length(); index++) {
      if(_xml.charAt(index) == '<') {
        beginIndex = index;
      }
      else if (_xml.charAt(index) == '>') {
        endIndex = index;
        String originalTag = _xml.substring(beginIndex, endIndex + 1);
        String newTag = originalTag;
        while(newTag.contains(" ")) {
          newTag = newTag.replace(" ", "_");
        }
        xml = xml.replace(originalTag, newTag);
      }
    }
    _xml = xml;
  }

  private static final void buildXML() {
    String data = "{\"Engineering\":{ \"Electrical Engineering\":{ \"Research Staff\":[\"research associate\",\"research sciencetist\",\"senior research sciencetist\"], \"Non-tenure-track\":[\"research professaor\",\"associate research professor\",\"assistant research profesor\",\"clinical profesor\",\"clinical associate profesor\",\"clinical assistant profesor\",\"visiting profesor\",\"visiting associate profesor\",\"visiting assistant profesor\"], \"Professional Staff\":[\"business manager\",\"university research administrator\",\"department administrative assistant\"]},";
    data += "\"Computer Science\":{ \"Research Staff\":[\"research associate\",\"research sciencetist\",\"senior research sciencetist\"], \"Tenured\":[\"distinguished professor\",\"professor\",\"associate professor\",\"assistant professor\"], \"Teaching Faculty\":[\"distinguished professor\",\"professor\",\"associate professor\",\"assistant professor\"]}, \"Computer Engineering\":{\"Tenured\":[\"distinguished professor\",\"professor\",\"associate professor\",\"assistant professor\"], \"Teaching Faculty\":[\"lecturer\",\"senior lecturer\",\"adjunct professor\"], \"Professional Staff\":[\"business manager\",\"university research administrator\",\"department administrative assistant\"]}";
    data += "},";
    data += "\"Science\":{ \"Physics\":{ \"Research Staff\":[\"research associate\",\"research sciencetist\",\"senior research sciencetist\"], \"Teaching Faculty\":[\"lecturer\",\"senior lecturer\",\"adjunct professor\"], \"Non-Tenured-Track\":[\"research professaor\",\"associate research professor\",\"assistant research profesor\",\"clinical profesor\",\"clinical associate profesor\",\"clinical assistant profesor\",\"visiting profesor\",\"visiting associate profesor\",\"visiting assistant profesor\"]},";
    data += "\"Chemistry\":{ \"Tenured\":[\"distinguished professor\",\"professor\",\"associate professor\",\"assistant professor\"], \"Teaching Faculty\":[\"lecturer\",\"senior lecturer\",\"adjunct professor\"], \"Non-Tenured-Track\":[\"research professaor\",\"associate research professor\",\"assistant research profesor\",\"clinical profesor\",\"clinical associate profesor\",\"clinical assistant profesor\",\"visiting profesor\",\"visiting associate profesor\",\"visiting assistant profesor\"]}";
    data += "}";
    data += "}";

    JSONObject json = new JSONObject(data);
    _xml = "<Root>" + XML.toString(json) + "</Root>";

    System.out.println(_xml);

  }

  private static final void setUIFont (javax.swing.plaf.FontUIResource f){
    Enumeration<Object> keys = UIManager.getDefaults().keys();
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      Object value = UIManager.get (key);
      if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
        UIManager.put (key, f);
      }
    }
  }

  private static final Node parse(String XMLContent) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new InputSource(new StringReader(XMLContent)));
    return document.getDocumentElement();
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ComboBoxChain frame;
        try {
          frame = new ComboBoxChain();
          frame.setVisible(true);
        }
        catch (ParserConfigurationException e) {
          e.printStackTrace();
        }
        catch (SAXException e) {
          e.printStackTrace();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }
}