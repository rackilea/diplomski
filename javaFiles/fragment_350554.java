public static String getJavaOutput() {
    try {
        String output = "";
        ProcessBuilder macBuilder = new ProcessBuilder("/bin/bash", "-c", "jps -lV && exit");
        Process p2 = macBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            output += line + System.getProperty("line.separator");
        }
        return output;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}