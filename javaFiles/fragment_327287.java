public void executeGetLogs(){
    try{
        Runtime rt = Runtime.getRuntime();
        String [] commands = {helper.getPythonPath(), helper.getLogsMainScript(), helper.getLogsManagementUrl(), helper.getLogsManagementUrlPrefix(), helper.getLogsManagementUsername(), helper.getLogsManagementPassword(), helper.getLogsNet(), helper.getLogsStorageUrl(), helper.getLogStorageUsername(), helper.getLogStoragePassword()};
        Process proc = rt.exec(commands);

        BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(proc.getInputStream()));

        try{
            proc.waitFor();
        }
        catch(InterruptedException e){
            logger.debug("Interrupted Exception : " + e);
        }

        BufferedReader stdError = new BufferedReader(new 
            InputStreamReader(proc.getErrorStream()));

        // read the output from the command
        logger.debug("Standard output from execution of get_logs:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            logger.debug(s);
        }

        // read any errors from the attempted command
        logger.debug("Standard error from execution of get_logs (if any):\n");
        while ((s = stdError.readLine()) != null) {
            logger.debug(s);
        }
    }
    catch(IOException e){
        logger.debug("Execution exception: " + e);
    }
}