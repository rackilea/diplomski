public class WinUtil {

    //returns mappings as (extension, mimetype) (without periods)
    public static Map<String, String> getMimeMappings() throws Exception {
        Map<String, String> extensions = new HashMap<String, String>();
        String result = WinUtil.doRegQuery("HKEY_CLASSES_ROOT\\Mime\\Database\\Content Type", "/s");
        if (result == null) {
            return null;
        }

        String path = null;
        String[] lines = result.split("\n");
        for (String line : lines) {

            line = line.replaceAll("\r", "");
            if (line.startsWith(" ") || line.startsWith(" ")) {
                line = line.trim();
                if (line.startsWith("Extension")) {
                    String[] entries = line.split("    ");
                    if (entries.length >= 3) {
                        String ext = entries[2].substring(1); //skip .                       

                        // we only split here, since Extension may not have been found, in which case it would have been a waste
                        String[] pathSplit = path.split("\\\\");
                        String key = pathSplit[pathSplit.length - 1];

                        extensions.put(ext.toLowerCase(), key.toLowerCase());
                    }
                }

            } else {
                line = line.trim();
                path = line;
            }
        }
        return extensions;
    }

    //return key locations and keys 
    public static String[] getRegSubKeys(String regLocation) {

        try {
            String result = doRegQuery(regLocation, "");

            if (result == null) {
                return null;
            } else if (result.isEmpty()) {
                return new String[0];      // empty string array
            }
            String[] strArray = result.split("\n");
            //remove form-feed characters, if any
            for (int i = 0; i < strArray.length; i++) {
                strArray[i] = strArray[i].replaceAll("\r", "");
            }
            return strArray;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //note when using this to use the abbreviated forms: i.e. 
    // HKCU, HKLM, etc.
    public static String setRegKey(String location, String regKey, String regValue) throws Exception {
        String regCommand = "add \"" + location + "\" /v \"" + regKey + "\" /f /d \"" + regValue + "\"";

        return doReg(regCommand);
    }

    public static String getRegKey(String regKey, String regKeyType, String regLocation) throws Exception {

        String regCommand = "/v \"" + regKey + "\"";

        String result = doRegQuery(regLocation, regCommand);

        int p = result.indexOf(regKeyType);
        if (p == -1) {
            throw new Exception("Could not find type of key in REG utility output");
        }
        return result.substring(p + regKeyType.length()).trim();
    }

    //may return null if exec was unsuccessful
    public static String doRegQuery(String regLocation, String regCommand) throws Exception {
        final String REGQUERY_UTIL = "Reg Query" + " ";
        final String regUtilCmd = REGQUERY_UTIL + "\"" + regLocation + "\" " + regCommand;
        return runProcess(regUtilCmd);
    }

    public static String doReg(String regCommand) throws Exception {

        final String REG_UTIL = "reg";
        final String regUtilCmd = REG_UTIL + " " + regCommand;
        return runProcess(regUtilCmd);
    }

    public static String runProcess(final String regUtilCmd) throws Exception {
        StringWriter sw = new StringWriter();
        Process process = Runtime.getRuntime().exec(regUtilCmd);

        InputStream is = process.getInputStream();
        int c = 0;
        while ((c = is.read()) != -1) {
            sw.write(c);
        }
        String result = sw.toString();
        try {
            process.waitFor();
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
        if (process.exitValue() == -1) {
            throw new Exception ("REG QUERY command returned with exit code -1");
        }
        return result;
    }
}