// Get the Classloader to load the XSLT
ClassLoader classloader = this.getClass().getClassLoader();
// Get th URL of the file
URL url = classloader.getResource("<your special place>/myStyle.xslt");
// Now you can read it...
InputStream in = url.openStream();
// ...or use it as a file
// ATTATION: This works only if the file is not inside a a JAR, WAR etc.
//           But it works inside your JUnit or TestNG tests and in an exploded WAR
File file = new File(url.toURI());