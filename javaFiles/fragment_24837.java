@RequestMapping(value = "/search/{index:.*}", method = RequestMethod.GET)
public void search(@PathVariable String index, @RequestParam Map<String, String> allRequestParams, HttpServletResponse response)
    throws IOException
{
    BoolQueryBuilder query = QueryBuilders.boolQuery();
    for (Map.Entry<String, String> entry : allRequestParams.entrySet()) {
        query.should(QueryBuilders.fuzzyQuery(entry.getKey(), entry.getValue()));
    }

    SearchResponse results = esClient.prepareSearch("nyc_visionzero")
        .setTypes("logs")
        .setQuery(query)
        .execute()
        .actionGet();

    SearchHits hits = results.getHits();

    ServletOutputStream os = response.getOutputStream();
    XContentBuilder builder = XContentFactory.jsonBuilder(os);
    results.toXContent(builder, ToXContent.EMPTY_PARAMS);
    builder.close();
    os.close();
}