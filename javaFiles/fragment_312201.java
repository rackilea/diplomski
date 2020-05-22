final ModelNode address = Operations.createAddress("subsystem", "undertow", "servlet-container", "default");
final ModelNode op = Operations.createReadAttributeOperation(address, "default-session-timeout");
try (ModelControllerClient client = ModelControllerClient.Factory.create("localhost", 9990)) {
    final ModelNode result = client.execute(op);
    if (!Operations.isSuccessfulOutcome(result)) {
        throw new RuntimeException(Operations.getFailureDescription(result).asString());
    }
    System.out.println(Operations.readResult(result).asInt());
}