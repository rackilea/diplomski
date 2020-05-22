import java.net.MalformedURLException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;

public class SolrQuery {
  public static void main(String[] args) throws MalformedURLException, SolrServerException {
    SolrServer server = new HttpSolrServer("http://localhost:8080/solr");
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("q", "1");

            QueryResponse response = server.query(params);

            System.out.println("response = " + response);

  }
}