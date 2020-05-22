import java.io.IOException;
import java.util.Iterator;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 * Sample app
 *
 */
public class App 
{
    public static void main( String[] args ) throws SolrServerException, IOException
    {
        String url = "https://localhost:8080/solr/";
        String httpAuthUser = "solr_admin";
        String httpAuthPass= "somePassword";
            // Configure latests Apache Http Components http client
        HttpClient httpClient = new DefaultHttpClient();
        if (httpAuthUser != null && httpAuthPass != null) {
            AbstractHttpClient client = (AbstractHttpClient) httpClient;
            App a = new App();
            client.addRequestInterceptor(a.new PreEmptiveBasicAuthenticator(httpAuthUser, httpAuthPass));
          }
        // Configure XMLResponseParser as standard javabin parser does not work with 1.4
        SolrServer solr = new HttpSolrServer(url, httpClient, new XMLResponseParser());
        // Test adding some data 
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "552199");
        document.addField("name", "Gouda cheese wheel");
        document.addField("price", "49.99");
        UpdateResponse uresponse = solr.add(document);
        System.out.println("UpdateResponse"+uresponse.getStatus());
        solr.commit();

        // Query for the data just added
        SolrQuery parameters = new SolrQuery();
        parameters.set("q", "*");
        QueryResponse response = solr.query(parameters);
        SolrDocumentList list = response.getResults();
        Iterator<SolrDocument> si = list.iterator();
        System.out.println("Solr document"+list.getNumFound());
        while(si.hasNext()){
            System.out.println("Solr document"+si.next().toString());
        }
    }


    protected class PreEmptiveBasicAuthenticator implements HttpRequestInterceptor {
          private final UsernamePasswordCredentials credentials;

          public PreEmptiveBasicAuthenticator(String user, String pass) {
            credentials = new UsernamePasswordCredentials(user, pass);
          }

          public void process(HttpRequest request, HttpContext context)
              throws HttpException, IOException {
            request.addHeader(BasicScheme.authenticate(credentials,"US-ASCII",false));
          }
        }
}