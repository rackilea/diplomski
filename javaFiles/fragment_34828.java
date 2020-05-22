public static Map<ConnectionRef, Constraint> getNextGatewayConstraints(final StatefulKnowledgeSession inSession,
                                                                       final WorkflowProcessInstanceImpl inInstance,
                                                                       final Node inTaskNode) {
    final Map<ConnectionRef, Constraint> constraints = new HashMap<>();
    final WorkflowProcess process = (WorkflowProcess) inSession.getKnowledgeBase().getProcess(inInstance.getProcessId());
    for (Node node : process.getNodes()) {
        if (!node.equals(inTaskNode)) {
            continue;
        }
        final List<Connection> nodeConnections = node.getOutgoingConnections(org.jbpm.workflow.core.Node.CONNECTION_DEFAULT_TYPE);
        if (nodeConnections != null && !nodeConnections.isEmpty()) {
            for (Connection c : nodeConnections) {
                final Node nextNode = c.getTo();
                if (nextNode instanceof Split) {
                    constraints.putAll(((Split) nextNode).getConstraints());
                    return constraints;
                }
            }
        }
        break;
    }
    return constraints;
}