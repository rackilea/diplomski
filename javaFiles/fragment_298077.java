Client client = ClientBuilder.newClient();
WebTarget target=client.target("http://188.166.152.46/task_manager/v1/tasks");
try{
    target.request(MediaType.APPLICATION_JSON).get(String.class);
} catch (WebApplicationException ex) {
    Response response = ex.getResponse();
    System.out.println(response.getStatusInfo() + "(" + response.getStatus()  + ")");
    System.out.println(response.readEntity(String.class));
}