System.setOut(new PrintStream(new File("stdout.txt")));
ProcessBuilder pb = new ProcessBuilder("... some args ...");
Process p = pb.start();
BufferedReader childOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line;
while ((line = output.readLine()) != null) {
    System.out.println(line); // child`s output goes to stdout.txt
}