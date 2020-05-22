package org.combobox;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class CleanNode {

  private String _name;
  private List<CleanNode> _nodes = new ArrayList<CleanNode>();

  public CleanNode(Node node) {
    _name = node.getNodeType() == Node.TEXT_NODE ? node.getNodeValue() : node.getNodeName();
  }

  private String getName() {
    return _name;
  }

  public CleanNode addChild(Node node) {
    CleanNode foundNode = null;
    String nodeName = node.getNodeName();
    for(CleanNode child : _nodes){
      if(child.getName().equals(nodeName)) {
        foundNode = child;
        break;
      }
    }
    if(foundNode == null) {
      foundNode = new CleanNode(node);
        _nodes.add(foundNode);
    }
    return foundNode;
  }

  public List<CleanNode> getNodes(){
    return _nodes;
  }

  public String toString() {
    return _name.replace("_", " ");
  }
}