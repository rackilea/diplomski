public class MyFilter implements ContainerResponseFilter {
    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        response.setEntity(new Transaction(response.getEntity()));
        return response;
    }
}