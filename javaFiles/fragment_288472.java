ProcessBuilder pb = new ProcessBuilder("command1", "--param1", "--param2");

// option 1 - redirect output to a file
pb.redirectErrorStream(true);
pb.redirectOutput(new File("out.txt"));
Process p = pb.start();

// option 2 - send output to the Java process's own System.out
pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
pb.redirectError(ProcessBuilder.Redirect.INHERIT);
Process p = pb.start();

// option 3 - read the output yourself in Java
pb.redirectErrorStream(true);
Process p = pb.start();
InputStream in = p.getInputStream();
BufferedReader reader = new BufferedReader(new InputStreamReader(in));
String line = null;
while((line = reader.readLine()) != null) {
  // do something with the line
}

// and once you've dealt with the output in one of these three ways...
int exitCode = p.waitFor();