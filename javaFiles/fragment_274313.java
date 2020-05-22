public static HashMap<String, String> getEnvVariables(String scriptFile ,String config1,String config2) {
    HashMap<String, String> vars = new HashMap<String, String>();
    BufferedReader br = null;
    try {
        FileInputStream fstream = new FileInputStream(scriptFile);
        br = new BufferedReader(new InputStreamReader(fstream));
        String strLine = null;
        String stopvar = config2;
        String startvar =config1;
        String keyword = "set";
        do {
            if (strLine != null && strLine.contains(startvar)) {
                if (strLine.contains(stopvar)) {
                    return vars;
                }
                while (strLine != null && !strLine.contains(stopvar)) {
                    strLine = br.readLine();
                    if (strLine.trim().startsWith(keyword)&& !strLine.contains("$")) {
                        strLine = strLine.trim().substring(keyword.length())
                        .trim();
                        String[] split = strLine.split("=");
                        String name = split[0];
                        String value = split[1];
                        System.out.println(name + "=" + value);
                        vars.put(name, value);
                    }
                }
            }
        } while ((strLine = br.readLine()) != null);
    } catch (Exception e) {
        Status status = new Status(Status.ERROR, Activator.PLUGIN_ID,
                IStatus.ERROR, e.getMessage(), e);
        Activator.getDefault().getLog().log(status);
    }
    return vars;
}