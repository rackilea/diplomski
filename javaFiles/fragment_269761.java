public Node convertToTouchGraph(
    Graph<V, E> graph,
    TGPanel tgPanel,
    boolean selfReferencesAllowed)
    throws TGException
{
    List<V> jgtNodes = new ArrayList<V>(graph.vertexSet());
    Node [] tgNodes = new Node[jgtNodes.size()];

    // add all the nodes...
    for (int i = 0; i < jgtNodes.size(); i++) {
        Node n;
        if (jgtNodes.get(i) instanceof Node) {
            // if our JGraphT object was a touchGraph node, add it unaltered
            n = (Node) jgtNodes.get(i);
        } else {
            // create a TG Node with a "label" and "id" equals to the
            // objects toString() value
            n = new Node(jgtNodes.get(i).toString());

        }

        // store this for edge-related creation below
        tgNodes[i] = n;
        tgPanel.addNode(n);
        tgNodes[i].setBackColor(Color.RED);