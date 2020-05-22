class Service {
    private String name, password;

    public Service(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // getters, setters if you'd like
}

Map<String, Service> services = new HashMap<>();
services.put("pandora", new Service("ziggy", "stardust"));
// etc.