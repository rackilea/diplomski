session = jsch.getSession("git", "github.com", 22);
session.setPassword("hunter2");

Properties prop = new Properties();
prop.put("StrictHostKeyChecking", "yes");
session.setConfig(prop);
session.connect();