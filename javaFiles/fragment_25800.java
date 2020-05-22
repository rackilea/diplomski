Path path = FileSystems.getDefault().getPath("c:", "temp", "rb-test");
ProcessBuilder pb = new ProcessBuilder("ruby.exe","foo.rb").directory(path.toFile()).redirectErrorStream(true);
pb.environment().remove("CLASSPATH");
Process process = pb.start();
process.waitFor();
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
String line = bufferedReader.readLine();
while (line != null) {
    System.out.println(line);
    line = bufferedReader.readLine();
}