@Component
public class ProductsRepositoryImpl implements ProductsRepositoryCustom {

  @Autowired
  private SolrServer   solrServer;

  public ProductsRepositoryImpl() {};

  public ProductsRepositoryImpl(SolrServer solrServer) {
    this.solrServer = solrServer;
  }

  public List<Map<String, Object>> findFields(String id, List<String> fields)
  {
    SolrQuery solrQuery = new SolrQuery("id:" + id);
    solrQuery.setFields(fields.toArray(new String[0]));
    try {
      QueryResponse response = this.solrServer.query(solrQuery);
      return response.getResults()
              .stream()
              .map(d ->
                {
                  return d.entrySet()
                          .stream()
                          .filter(e -> fields.contains(e.getKey()))
                          .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
                }).collect(Collectors.toList());
    } catch (SolrServerException e) {
      // TODO Auto-generated catch block
    }
    return Collections.emptyList();
  }

}