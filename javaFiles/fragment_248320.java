// Create and start the process
Process pb = new ProcessBuilder("java", "Solution").start();
// Create a reader to read in each output line
BufferedReader reader = new BufferedReader(new InputStreamReader(pb.getInputStream()));
String line;
// Read in line by line
while((line = reader.readLine()) != null) {
    // ...
}