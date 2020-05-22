ModelNode op = new ModelNode();
op.get(ClientConstants.OP).set("change-file");
//change MYHANDLER 
op.get(ClientConstants.OP_ADDR).set("/subsystem=logging/periodic-rotating-file-handler=MYHANDLER");

//set new file name as new_file_name.log
ModelNode file = new ModelNode();
file.get("relative-to").set("jboss.server.log.dir");
file.get("path").set("new_file_name.log");
op.get("file").set(file);

ModelControllerClient client = ModelControllerClient.Factory.create("localhost", 9999);
ModelNode result = client.execute(op);

if (result.hasDefined("outcome") && "success".equals(result.get("outcome").asString())) {
    if (result.hasDefined("result")) {
        System.out.println(result.get("result"));
    }
} else if (result.hasDefined("failure-description")) {
    throw new RuntimeException(result.get("failure-description").toString());
} else {
    throw new RuntimeException("Operation not successful; outcome = " + result.get("outcome"));
}