static void startJetty() {
    try {
        Server server = new Server();
        Connector con = new SelectChannelConnector();
        con.setPort(80);
        server.addConnector(con);
        Context context = new Context(server, "/", Context.SESSIONS);
        context.addServlet(new ServletHolder(new MyApp()), "/*");
        server.start();
    } catch (Exception ex) {
        System.err.println(ex);
    }
}