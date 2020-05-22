try {
  String jbossBinDir = System.getProperty("jboss.server.base.dir").replace("standalone", "bin");
  Runtime.getRuntime().exec("sh " + jbossBinDir + "/jboss-cli.sh -c command=:shutdown");
} catch(IOException e) {
  ...
}