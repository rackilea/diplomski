ProcessBuilder pb = new ProcessBuilder("java", "-version");
pb.directory(new File(System.getProperty("user.home")));
Process p = pb.start();
BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
String javaVersion = reader.readLine();
System.out.println(javaVersion.substring(javaVersion.indexOf("\"") + 1, javaVersion.lastIndexOf("\"")));