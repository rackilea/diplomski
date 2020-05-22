ProcessBuilder pb = new ProcessBuilder("myshell.sh", "myArg1", "myArg2");
 Process p = pb.start();
 BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
 String line = null;
 while ((line = reader.readLine()) != null)
 {
    System.out.println(line);
 }