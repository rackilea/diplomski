try {
    ProcessBuilder pb = new ProcessBuilder("/bin/bash", "/full/path/of/myScript.sh" );
    Process pr = pb.start(); 
    InputStreamReader isr = new InputStreamReader(pr.getInputStream());
    BufferedReader br = new BufferedReader(isr);
    String line;
    while((line = br.readLine()) != null)
        System.out.println(line);
    int exitVal = pr.waitFor();
    System.out.println("exitVal: " + exitVal);
} catch(Exception e) {  e.printStackTrace();  }