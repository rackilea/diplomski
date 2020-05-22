private boolean exists(final ModelControllerClient client, final String deploymentName) {
    final ModelNode op = new ModelNode();
    op.get(OP).set("read-children-names");
    op.get("child-type").set(ClientConstants.DEPLOYMENT);
    final ModelNode result;
    try {
        result = client.execute(op);
        // Check to make sure there is an outcome
        if (result.hasDefined(ClientConstants.OUTCOME)) {
            if (result.get(ClientConstants.OUTCOME).asString().equals(ClientConstants.SUCCESS)) {
                final List<ModelNode> deployments = (result.hasDefined(ClientConstants.RESULT) ? result.get(ClientConstants.RESULT).asList() : Collections.<ModelNode>emptyList());
                for (ModelNode n : deployments) {
                    if (n.asString().equals(deploymentName)) {
                        return true;
                    }
                }
            } else if (result.get(ClientConstants.OUTCOME).asString().equals(ClientConstants.FAILED)) {
                throw new IllegalStateException(String.format("A failure occurred when checking existing deployments. Error: %s",
                        (result.hasDefined(ClientConstants.FAILURE_DESCRIPTION) ? result.get(ClientConstants.FAILURE_DESCRIPTION).asString() : "Unknown")));
            }
        } else {
            throw new IllegalStateException(String.format("An unexpected response was found checking the deployment. Result: %s", result));
        }
    } catch (IOException e) {
        throw new IllegalStateException(String.format("Could not execute operation '%s'", op), e);
    }
    return false;
}