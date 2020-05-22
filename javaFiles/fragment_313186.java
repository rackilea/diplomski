@BeforeClass
public static void beforeClass() throws Exception {
    // Set appropriate paths for Solr to use.
    System.setProperty("solr.solr.home", "src/test/resources/solr");
    System.setProperty("solr.data.dir", "target/test-classes/solr/data");

    // Instruct Solr to keep the index in memory, for faster testing.
    System.setProperty("solr.directoryFactory", "solr.RAMDirectoryFactory");

    // Start a Solr instance.
    solrRunner = new JettySolrRunner("src/test/resources/solr", "/solr", getPort());
    solrRunner.start();

    solrServer = new HttpSolrServer("http://localhost:" + getPort() + "/solr");
}

@AfterClass
public static void afterClass() throws Exception {
    if (solrRunner != null) {
        solrRunner.stop();
    }
}