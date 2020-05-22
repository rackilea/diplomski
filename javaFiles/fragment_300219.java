private File getHomeDirectoryOf(String username) throws IOException, Exception{
    String[] command = new String[]{"/bin/sh", "-c", "echo ~"+username + ""};
    Process echo = Runtime.getRuntime().exec(command);
    BufferedReader br = new BufferedReader(new InputStreamReader(echo.getInputStream()));

    try{
        echo.waitFor();
    }
    catch(InterruptedException e){

    }

    String path = br.readLine();
    echo.destroy();

    if(path.contains("~")){
        System.out.println("Home directory for " + username + " cannot be found.");
        throw new Exception();
    }
    else{
        return new File(path);
    }
}