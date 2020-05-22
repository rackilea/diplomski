try
         {
             Cassandra.Client client = ConfigHelper.getClientFromOutputAddressList(conf);
+
+            if (ConfigHelper.getOutputKeyspaceUserName(conf) != null)
+            {
+                Map<String, String> credentials = new HashMap<String, String>();
+                credentials.put(IAuthenticator.USERNAME_KEY, ConfigHelper.getOutputKeyspaceUserName(conf));
+                credentials.put(IAuthenticator.PASSWORD_KEY, ConfigHelper.getOutputKeyspacePassword(conf));
+                AuthenticationRequest authRequest = new AuthenticationRequest(credentials);
+                client.login(authRequest);
+            }
+
             retrievePartitionKeyValidator(client);
             String cqlQuery = CqlConfigHelper.getOutputCql(conf).trim();
             if (cqlQuery.toLowerCase().startsWith("insert"))