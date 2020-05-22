@Override
public void readEntityCollection(final ODataRequest request,
              ODataResponse response, final UriInfo uriInfo,
              final ContentType requestedContentType)
              throws ODataApplicationException, SerializerException {
    (...)
    EntitySet entitySet = dataProvider.readEntitySet(edmEntitySet,
                uriInfo.getFilterOption(), uriInfo.getSelectOption(),
                uriInfo.getExpandOption(), uriInfo.getOrderByOption(),
                uriInfo.getSkipOption(), uriInfo.getTopOption());

    (...)
}