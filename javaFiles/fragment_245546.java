public void zipMultipleFiles (List<file> Files, String destinationFile){
        String zipApplication = "\"C:\\Program Files\7Zip\7zip.exe\" a -t7z"; 
        String CommandToZip = zipApplication + " ";    
        for (File file : files){
           CommandToZip = CommandToZip + "\"" + file.getAbsolutePath() + "\" ";
        }
        CommandToZip = CommandToZip + " -mmt -mx5 -aoa";
        runCommand(CommandToZip);
    }

    public void runCommand(String commandToRun) throws RuntimeException{
        Process p = null;
        try{
            p = Runtime.getRuntime().exec(commandToRun);
            String response = convertStreamToStr(p.getInputStream());
            p.waitFor();
        } catch(Exception e){
            throw new RuntimeException("Illegal Command ZippingFile");
        } finally {
            if(p = null){
                throw new RuntimeException("Illegal Command Zipping File");
            }
            if (p.exitValue() != 0){
                throw new Runtime("Failed to Zip File - unknown error");
            }
        }
    }