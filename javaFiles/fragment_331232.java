Process p = pb.start();  
p.waitFor();  // wait for process to finish then continue.

BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));

while ((line = bri.readLine()) != null) {
    RESULT+=line;
}