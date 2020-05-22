JavaMigrations migrations[] = {myJavaMigration};
Flyway flyway = Flyway.configure()
                     .dataSource(url, user, password)
                     .javaMigrations(migrations)
                     .load();
flyway.migrate();