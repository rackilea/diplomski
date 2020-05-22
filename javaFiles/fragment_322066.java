Configuration configuration = new Configuration();
        try {
            classes().forEach(cl -> {
                configuration.addAnnotatedClass(cl);
            });
            configuration.setProperty("hibernate.dialect", HSQLCustomDialect.class.getName());
            SchemaExport schemaExport = new SchemaExport(configuration);
            schemaExport.setOutputFile("someFileName.sql");
            schemaExport.setFormat(false);
            schemaExport.setDelimiter(";");
            schemaExport.execute(true, false, false, true);