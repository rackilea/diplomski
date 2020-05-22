java.util.Properties props = new java.util.Properties();
        props.setProperty(AdminClient.CONNECTOR_TYPE, AdminClient.CONNECTOR_TYPE_SOAP);
        props.setProperty(AdminClient.CONNECTOR_HOST, "localhost");
        props.setProperty(AdminClient.CONNECTOR_PORT, "8880");
        props.setProperty(AdminClient.CONNECTOR_SECURITY_ENABLED, "true");
        props.setProperty(AdminClient.USERNAME, "admin");
        props.setProperty(AdminClient.PASSWORD, "111111");

        client = AdminClientFactory.createAdminClient(props);

        //Проверяем список запущенных приложений
        AppManagement appM = AppManagementProxy.getJMXProxyForClient(client);
        Vector apps = appM.listApplications(null, null, null);
        System.out.println("     Status    |   Application   ");

        for (int i = 0; i < apps.size(); i++) {
            String queryString = "WebSphere:type=Application,name=" + apps.get(i) + ",*";
            ObjectName queryAppObj = new ObjectName(queryString);
            Set<?> result = client.queryNames(queryAppObj, null);
            if (result.size() == 0) {
                System.out.println("     Stopped   |   " + apps.get(i));
            } else {
                System.out.println("     Running   |   " + apps.get(i));
            }
        }