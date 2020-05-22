ClientConnectionRequest connRequest = connMrg.requestConnection(
        new HttpRoute(new HttpHost("localhost", 80)), null);
ManagedClientConnection conn = connRequest.getConnection(10, TimeUnit.SECONDS);
try {
    BasicHttpRequest request = new BasicHttpRequest("GET", "/");
    conn.sendRequestHeader(request);
    HttpResponse response = conn.receiveResponseHeader();
    conn.receiveResponseEntity(response);
    HttpEntity entity = response.getEntity();
    if (entity != null) {
        BasicManagedEntity managedEntity = new BasicManagedEntity(entity, conn, true);
        // Replace entity
        response.setEntity(managedEntity);
    }
    // Do something useful with the response
    // The connection will be released automatically 
    // as soon as the response content has been consumed
} catch (IOException ex) {
    // Abort connection upon an I/O error.
    conn.abortConnection();
    throw ex;
}