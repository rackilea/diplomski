String host = "172.16.200.100"; // Platform IP
int port = 1099; // default-port 1099

String MTP_hostIP = "172.16.200.100"; 
String MTP_Port = "7778";

Runtime runtime = Runtime.instance();

Profile profile = new ProfileImpl(host, port, null, true);  
profile.setParameter(Profile.MTPS, "jade.mtp.http.MessageTransportProtocol(http://"+MTP_hostIP+":"+MTP_Port+"/acc)");

// create container
AgentContainer container = runtime.createMainContainer(profile);

try {
    AgentController ac = container.createNewAgent("AgentSmith",AgentSmith.class.getName(),null);
    ac.start();
} catch (StaleProxyException e) {
    e.printStackTrace();
}