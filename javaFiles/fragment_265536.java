public static class Archive {
    private String host;
    private String database;
    private String port;

    public Archive() {
        // TODO Auto-generated constructor stub
    }

    public Archive(String host, String database, String port) {
        System.out.println("constri=uu Archive");
        this.host = host;
        this.database = database;
        this.port = port;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getDatabase() {
        return database;
    }
    public void setDatabase(String database) {
        this.database = database;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    @Override
    public String toString() {
        return "Archive [host=" + host + ", database=" + database + ", port=" + port + "]";
    }

}