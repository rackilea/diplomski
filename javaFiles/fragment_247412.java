public int countDistinctClientIPAddresses() {
    try {
        readLogFile();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    Set<String> uniqueIPs = new HashSet<String>();
    for (int k = 0; k < count; k++) {
        uniqueIPs.add(entryLog[k].getCsIpAddress());
    }

    return uniqueIPs.size();
}