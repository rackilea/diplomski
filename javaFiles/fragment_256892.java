private static void getServerAndConnect() {
    List<ServerPref> serverPrefs = Arrays.asList(Properties.ServerPref1, Properties.ServerPref2, Properties.ServerPref3);

    for (ServerPref serverPref : serverPrefs) {
        try {
            connect(serverPref);
            // test success of connection? and break out of the loop
            break;
        } catch (ServerException se1) {
            // log error and go onto next one
        }
    }
}