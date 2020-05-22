Map<String, String> env = System.getenv();
Map<String, Object> configOverrides = new HashMap<String, Object>();
for (String envName : env.keySet()) {
    if (envName.contains("DB_USER")) {
        configOverrides.put("toplink.jdbc.user", env.get(envName)));    
    }
    // You can put more code in here to populate configOverrides...
}

EntityManagerFactory emf =
    Persistence.createEntityManagerFactory("default", configOverrides);