public int getWirelessStrength() {
    // The returned integer value is in relation to strength percent.
    // If 75 is returned then the wireless signal strength is at 75%.
    List<String> list = new ArrayList<>();
    int signalStrength = 0;
    String cmd = "netsh wlan show interfaces"; 
    try {
        Process p = Runtime.getRuntime().exec("cmd /c " + cmd);
        p.waitFor();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        }
        if (p.isAlive()) { p.destroy(); }

        // Get the Signal Strength.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).trim().toLowerCase().startsWith("signal")) {
                String[] ss = list.get(i).split(":");
                if(ss.length == 2) {
                    signalStrength = Integer.parseInt(ss[1].replace("%","").trim());
                }
                break;
            }
        }
    }
    catch (IOException | InterruptedException ex) { 
        Logger.getLogger("getWirelessStrength()").log(Level.SEVERE, null, ex);
    }
    return signalStrength;
}