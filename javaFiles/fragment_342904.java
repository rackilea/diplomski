public void handleSearch(Integer ctx, SearchRequest request,
        SearchResultHandler responseHandler, IntermediateResponseHandler intermediateResponseHandler)
    throws UnsupportedOperationException {
    if (request.getScope() == SearchScope.BASE_OBJECT && request.getName().isRootDN()) {
        logger.debug("LDAP Search: BASE_OBJECT");
        responseHandler.handleEntry(Responses.newSearchResultEntry(rootEntry));
    } else {
        // do the search
        // parameters: request.getName(), request.getScope(), request.getFilter()
    }

    responseHandler.handleResult(Responses.newResult(ResultCode.SUCCESS));
}