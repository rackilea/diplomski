...
JSch jsch = new JSch();
Session session = jsch.getSession(user, host, port);
Hashtable<String, String> config = new Hashtable<String, String>();
config.put("StrictHostKeyChecking", "no");
session.setConfig(config);
session.connect();
...