ProcessBuilder pb=new ProcessBuilder(command);
    pb.redirectErrorStream(true);
    Process process=pb.start();
    BufferedReader inStreamReader = new BufferedReader(
        new InputStreamReader(process.getInputStream())); 

    while(inStreamReader.readLine() != null){
        //do something with commandline output.
    }