private void getServerRouter(List<Server> l) {
    l.add(server);
    if (parent != null) {
        parent.getServerRouter(l)
    }
}

public Server[] getServerRouter() {
    List<Server> l = new ArrayList<>();
    getServerRouter(l);
    return l.toArray(new Server[l.size()]);
}