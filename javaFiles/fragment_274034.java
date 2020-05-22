public class Filter implements ContainerResponseFilter {
    @Context UriInfo uriInfo;
    @Context ExtendedUriInfo extendedUriInfo;

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        System.out.println(uriInfo.getMatchedResources().get(0).getClass());
        System.out.println(extendedUriInfo.getMatchedMethod().toString());
        return response;
    }
}