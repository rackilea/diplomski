List<TCPConnection> getAllEstablished() {
    List<TCPConnection> list = new ArrayList<TCPConnection>();

    for(TCPConnection tcp : allConnections) {
        if(tcp.isEstablished()) {
            list.add(tcp);
        }
    }

    return list;
}