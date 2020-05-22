Configuration configuration = new Configuration();
configuration.configure();

PropertyResourceBundle prop = (PropertyResourceBundle) ResourceBundle.getBundle("db/db");

// Basic connection information
configuration.setProperty("hibernate.connection.username", prop.getString("db.username"));
configuration.setProperty("hibernate.connection.password", prop.getString("db.password"));
configuration.setProperty("hibernate.connection.url", prop.getString("db.url"));
configuration.setProperty("hibernate.connection.driver_class", prop.getString("db.driver"));
configuration.setProperty("hibernate.dialect", prop.getString("db.dialect"));
configuration.setProperty("hibernate.default_schema", prop.getString("db.default_schema"));

configuration.setProperty("hibernate.current_session_context_class", prop.getString("hibernate.session_context"));

// Handling SQL statements in the logs
configuration.setProperty("show_sql", prop.getString("hibernate.show_sql"));
configuration.setProperty("format_sql", prop.getString("hibernate.format_sql"));
configuration.setProperty("use_sql_comments", prop.getString("hibernate.use_sql_comments"));

// C3P0 Settings
configuration.setProperty("hibernate.c3p0.min_size", prop.getString("hibernate.c3p0.min_size"));
configuration.setProperty("hibernate.c3p0.max_size", prop.getString("hibernate.c3p0.max_size"));
configuration.setProperty("hibernate.c3p0.timeout", prop.getString("hibernate.c3p0.timeout"));
configuration.setProperty("hibernate.c3p0.max_statements", prop.getString("hibernate.c3p0.max_statements"));
configuration.setProperty("hibernate.c3p0.idle_test_period", prop.getString("hibernate.c3p0.idle_test_period"));
configuration.setProperty("hibernate.c3p0.preferredTestQuery", prop.getString("hibernate.c3p0.preferredTestQuery"));