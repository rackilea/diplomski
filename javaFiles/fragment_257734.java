localhost:JBoss-EAP-7.1 daniel$ bin/jboss-cli.sh 
You are disconnected at the moment. Type 'connect' to connect to the server or 'help' for the list of supported commands.
[disconnected /] connect
[standalone@localhost:9990 /] patch apply /Users/daniel/Downloads/wildfly-11.0.0.Final-weld-2.4.6.Final-patch.zip --override-all
{
    "outcome" : "success",
    "response-headers" : {
        "operation-requires-restart" : true,
        "process-state" : "restart-required"
    }
}
[standalone@localhost:9990 /]