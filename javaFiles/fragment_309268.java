String cUrlToKeyCloak = "curl -k -d \"client_id=someId\" -d \"username="+username+"\" -d \"password="+password+"\" -d \"grant_type=password\" "+keyCloakUrl+"/auth/realms/master/protocol/openid-connect/token";

    ProcessBuilder processBuilder = new ProcessBuilder();
    if(!System.getProperty("os.name").contains("Windows"))
        processBuilder.command("bash", "-c", cUrlToKeyCloak );
    else
        processBuilder.command("cmd.exe", "/c", cUrlToKeyCloak );

    String cKeyResponse = "";

    try {

        Process process = processBuilder.start();
        StringBuilder output = new StringBuilder();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        int exitVal = process.waitFor();
        if (exitVal == 0) {
            LOGGER.info("Curl command to keyCloak requested ...");
            LOGGER.info("cKey response = "+output);
            cKeyResponse = output.toString();
        } else {
            LOGGER.error("Curl command to keyCloak executed with error ...");
            LOGGER.info("cKey response = "+output);
            return false;
        }

    } catch (IOException e) {
        e.printStackTrace();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }