private void serviceConnections() {
    boolean serverRunning = true;

    while (serverRunning) {
        try {
            Socket conn = ss.accept();
            System.out.println("Connection established!");
            serviceRequests(conn);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
    try {
        ss.close();
    } catch (Exception exc) {
    }
}// serviceConnections