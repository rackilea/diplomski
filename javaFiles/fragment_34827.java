public static List<Node> getProcessActiveNodeList(final StatefulKnowledgeSession inSession,
                                                                 final WorkflowProcessInstanceImpl inInstance) {
    final List<Node> nodes = new ArrayList<>();
    final WorkflowProcess process = (WorkflowProcess) inSession.getKnowledgeBase().getProcess(inInstance.getProcessId());
    for (Node node : process.getNodes()) {
        if (node instanceof EventNode && ((EventNode) node).getFrom() == null) {
            // a free-standing event, without an entry point;  this would be a start of an "optional" branch
            nodes.add(node);
        } else {
            // a node that has an inbound connection;  all nodes on the main branch are of this kind
            List<NodeInstance> nodeInstances = inInstance.getNodeInstances(node.getId());
            if (nodeInstances != null && !nodeInstances.isEmpty()) {
                for (NodeInstance nodeInstance : nodeInstances) {
                    Node nodeInstanceNode = process.getNode(nodeInstance.getNodeId());
                    nodes.add(0, nodeInstanceNode);
                }
            }
        }
    }
    return nodes;
}