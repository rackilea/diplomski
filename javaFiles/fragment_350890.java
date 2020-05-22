...
JSch jsch = new JSch();
jsch.setKnownHosts(knownHostsFilename);
Session session = jsch.getSession(user, host, port);
Hashtable<String, String> config = new Hashtable<String, String>();
config.put("StrictHostKeyChecking", "yes");
session.setConfig(config);
session.connect();
...