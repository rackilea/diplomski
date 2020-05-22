MultiThreadedHttpConnectionManager connectionManager;
void configureCachedHttpClient() {
        connectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = connectionManager.getParams();
        params.setConnectionTimeout(timeout); // set connection timeout (how long it takes to connect to remote host)
        params.setSoTimeout(timeout); // set socket timeout (how long it takes to retrieve data from remote host)
        params.setDefaultMaxConnectionsPerHost(maxTotalConnections);
        params.setMaxTotalConnections(maxTotalConnections);

        HttpClient httpClient = null;
        try {
            httpClient = new HttpClient(connectionManager);
            HttpConnectionManagerParams connectionManagerParams = httpClient.getHttpConnectionManager().getParams();
            connectionManagerParams.setParameter("http.connection-manager.timeout", timeout); // set timeout on how long we'll wait for a connection from the pool

            context.setProperty(HTTPConstants.MULTITHREAD_HTTP_CONNECTION_MANAGER, connectionManager);
            context.setProperty(HTTPConstants.CACHED_HTTP_CLIENT, httpClient);
            context.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);
            // context.setProperty(HTTPConstants.AUTO_RELEASE_CONNECTION, true);
        } catch (Exception e) {
            // Exception e
            httpClient = null;
            e.printStackTrace();
        } finally {
            httpClient = null;
        }
    }