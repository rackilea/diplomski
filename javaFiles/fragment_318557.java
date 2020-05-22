// Hibernate settings equivalent to hibernate.cfg.xml's properties
    Properties settings = new Properties();
    settings.put("show_sql", "false");
    settings.put("current_session_context_class", "thread");
    settings.put("hbm2ddl.auto", "none");
    settings.put("hibernate.dialect", "com.tracelink.analytics.dlreporting.db.CustomRedshiftDialect");