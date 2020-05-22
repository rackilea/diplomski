public enum DBRegistry {
   MYSQL("ab.cde.MySQL", "MySQL", MySQL.class),
   POSTGRESQL("ab.cde.PostgreSQL", "PostgreSQL", PostgreSQL.class);

   private String name;
   private String identifier;
   private Class<?> dbClass;

   private DBRegistry(String identifier, String name, Class<?> dbClass) {
       this.identifier = identifier;
       this.name = name;
       this.dbClass = dbClass;
   }
   // Getters...
}