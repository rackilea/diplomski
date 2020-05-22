protected void decode(Socket server) throws Exception {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));

    /*
     * Somewhere in this loop, detect your protocol's termination condition
     * and break out.
     */

    for (;;) {
        final int handshake = Integer.parseInt(reader.readLine());
        if (handshake == LOGIN) {
            final Session session = new LoginSession(server, reader);
            session.read(-1);
        } else if (handshake == POST_LOGIN) {
            final int index = Integer.parseInt(reader.readLine());
            final int opcode = Integer.parseInt(reader.readLine());
            final Session session = store.get(index).getSession();
            session.reader = reader;
            session.read(opcode);
        }
    }
}