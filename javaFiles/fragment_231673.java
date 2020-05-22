org.apache.tomcat.util.net.URL url = null;
try {
  url = new org.apache.tomcat.util.net.URL("/user/2/update?updates=success");
  // ... do some stuff with it...
} catch (Exception e) {
  e.printStackTrace();
}