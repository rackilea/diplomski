public ActionFuture<ValidateQueryResponse> validateAsync(QueryBuilder query, String[] indices) {
    final ValidateQueryRequest request = new ValidateQueryRequest();
    request.indices(indices);
    request.source(query.buildAsBytes());
    return esClient.admin().indices().validateQuery(request);
}