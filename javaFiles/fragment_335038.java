CommonsHttpSolrServer server = new CommonsHttpSolrServer(MY_SERVER_URL);

SolrInputDocument doc = new SolrInputDocument();
UUID uuid = UUID.randomUUID();
doc.addField("id", uuid.toString());
// [...] multiple addField calls
server.add(doc);
UpdateResponse ur = server.commit();