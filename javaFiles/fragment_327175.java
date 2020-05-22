public static void main(String[] args) {   
    String filePath = args[0];        
    String operatingSystem = System.getProperty("os.name");
    try{
        if(operatingSystem.toLowerCase().contains("windows")){
            ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c",filePath);                
            Process p = pb.start();                

        } else if (operatingSystem.toLowerCase().contains("linux")){                
            ProcessBuilder pb = new ProcessBuilder("xdg-open",filePath);
            Process p = pb.start();

        } else {
            throw new UnsupportedOperationException(String.format("Not supported for %1$1s", operatingSystem));
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}