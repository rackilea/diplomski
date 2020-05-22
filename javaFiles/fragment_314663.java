private static String executeCommand(String command) {

    StringBuffer output = new StringBuffer();
    System.out.println("command is = \n"+command);
    Process p;
    try {
        p = Runtime.getRuntime().exec("cmd.exe /c "+command); // <-correction done here
        p.waitFor();
        BufferedReader reader =
                           new BufferedReader(new InputStreamReader(p.getInputStream()));

                       String line = "";
        while ((line = reader.readLine())!= null) {
            output.append(line + "\n");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return output.toString();

}