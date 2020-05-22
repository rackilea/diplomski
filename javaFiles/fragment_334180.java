import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.*;

Configuration configuration = new Configuration()
    .withJdbc(new Jdbc()
        .withDriver("org.postgresql.Driver")
        .withUrl("jdbc:postgresql://localhost/your_database")
        .withUser("username")
        .withPassword("password"))
    .withGenerator(new Generator()
        .withName("org.jooq.util.DefaultGenerator")
        .withDatabase(new Database()
                .withName("org.jooq.util.postgres.PostgresDatabase")
                .withIncludes(".*")
                .withSchemata(new Schema().withInputSchema("your_schema"))
        )
        .withTarget(new Target()
            .withPackageName("jooq.generate")
            .withDirectory("src/main/java")));
try {
  GenerationTool.generate(configuration);
} catch (Exception e) {
  e.printStackTrace();
}