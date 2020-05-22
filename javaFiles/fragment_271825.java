public ArrayList<String> getClientList() {
    ArrayList<String> clientList = new ArrayList<>();
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader("/proc/net/arp"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] clientInfo = line.split(" +");
            String mac = clientInfo[3];
            if (mac.matches("..:..:..:..:..:..")) { // To make sure its not the title
                clientList.add(clientInfo[0]);
            }
        }
    } catch (java.io.IOException aE) {
        aE.printStackTrace();
        return null;
    }
    return clientList;
}