class Main {
    public static void main(String[] args) {
        Server server = new Server();
        server.method();

        Entity entity = server.getEntity();
        //print entity
    }
}

class Server {
    private Entity entity;

    public void method() {
        entity = new Entity();
        entity.setName(...);
        entity.setData(...);
    }

    public Entity getEntity() {
        return entity;
    }
}