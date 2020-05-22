try {
    server = new ServerSocket(this.getServerPort());
    while(true) {
        socket = server.accept();
        new Handler( socket );
    }
} catch (IOException e) {
    if (server != null && !server.isClosed()) {
        try {
            server.close();
        } catch (IOException e)
        {
            e.printStackTrace(System.err);
        }
    }
}