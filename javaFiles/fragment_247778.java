JServer server = new JServer();

        server.setUrl("http://localhost:8080/jasperserver/services/repository");

        server.setUsername("username");

        server.setPassword("password");

        WSClient client = new WSClient(server);

        ResourceDescriptor resourceDescriptor = new ResourceDescriptor();

        resourceDescriptor.setUriString ("/reports/myreportname");

        Map<String, Object> parameterMap = new HashMap<String, Object>();

        parameterMap.put("MY_PARAMETER_NAME", "myparametervalue");

        JasperPrint printer = client.runReport(resourceDescriptor, parameterMap);

        JasperViewer.viewReport(printer, false, Locale.GERMAN);