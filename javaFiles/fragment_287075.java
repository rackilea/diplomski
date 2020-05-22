public static void main(String[] args) {
    Component component = new Component();
    component.getServers().add(Protocol.HTTP, 8080);
    (...)
    component.start();
}