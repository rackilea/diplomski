JSch jsch = new JSch();
jsch.addIdentity("~/.ssh/id_rsa");

Session jumpboxSession = jsch.getSession("username", "jumpbox");
jumpboxSession.connect();

int serverSshPort = jumpboxSession.setPortForwardingL(0, "server", 22);
Session serverSession = jsch.getSession("username", "localhost", serverSshPort);
serverSession.connect();