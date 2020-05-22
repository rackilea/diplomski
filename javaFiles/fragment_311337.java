public void checkParsability()
{
    //while positive int edges is true and therefore all edges can be parsed as positive integers
    if (positive_int_edges)

    {
        for (Node n : this.nodeList)
        {
            for (Edge a : n.getOutgoingEdges()) {
                this.setPositive_int_edges(isInteger(a.getLabel()));
                //positive_int_edges = isInteger(a.getLabel());
                break;
            ]

            for (Edge a : n.getIncomingEdges()) {
                this.setPositive_int_edges(isInteger(a.getLabel()));
                //positive_int_edges = isInteger(a.getLabel());
                break;
            }
        }
    }
    //return positive_int_edges;
}