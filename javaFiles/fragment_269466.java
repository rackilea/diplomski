int fromNodeId = new Integer(values[0]);
int toNodeId = new Integer(values[1]);
int speedKbps = new Integer(values[2]);

Node fromNode = nodes.get(fromNodeId);
if (fromNode == null) //if we haven't seen this node already, create it and add it to the map
{
   fromNode = new Node(fromNodeId);
   nodes.put(fromNodeId, fromNode);
}

Node toNode = nodes.get(toNodeId);
if (toNode == null) //if we haven't seen this node already, create it and add it to the map
{
   toNode = new Node(toNodeId);
   nodes.put(fromNodeId, toNode);
}

Connection connection = new Connection(toNode, speedKbps);
fromNode.addConnection(connection);