BufferedReader stdInput = new BufferedReader(new 
     InputStreamReader(p.getInputStream()));


// read the output from the command
System.out.println("EXE OUTPUT");
while ((s = stdInput.readLine()) != null) {
    System.out.println(s);
}