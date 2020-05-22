final Session session = workflowSession.getSession(); 
final WorkflowData data = workItem.getWorkflowData();
String path = null;
String type = data.getPayloadType();
try {
    if (type.equals(TYPE_JCR_PATH) && data.getPayload() != null) {
        String payloadData = (String) data.getPayload();
        if (session.itemExists(payloadData)) {
            path = payloadData;
        }
    }
    NodeUtils nodeUtils = new NodeUtils();
    if (path != null) {
        final Node payloadNode = (Node) session.getItem(path);
        final Node node = nodeUtils.getMainAsset(payloadNode, ASSET_NODE_TYPE, ROOT_NODE_TYPE);
...