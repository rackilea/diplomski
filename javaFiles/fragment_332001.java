public class PurgeErrorEntityResponseFilter implements ContainerResponseFilter {
    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        if(response.getStatus() == 400) {
            response.setEntity(null);
        }
        return response;
    }
}