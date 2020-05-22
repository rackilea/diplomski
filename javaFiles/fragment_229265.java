import com.google.gson.JsonObject;
import com.rallydev.rest.RallyRestApi;
import com.rallydev.rest.request.QueryRequest;
import com.rallydev.rest.response.QueryResponse;
import com.rallydev.rest.util.Fetch;
import com.rallydev.rest.util.QueryFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class aRESTstories {

    public static void main(String[] args) throws URISyntaxException, IOException {


        String host = "https://rally1.rallydev.com";
            String username = "user@co.com";
            String password = "secret";
            String projectRef = "/project/2222";
            String workspaceRef = "/workspace/1111"; 
            String applicationName = "RESTExampleStoriesChildren";


        RallyRestApi restApi = new RallyRestApi(
                new URI(host),
                username,
                password);
        restApi.setApplicationName(applicationName); 

        System.out.println(restApi.getWsapiVersion()); //v.2.0 by default when using 2.0.2 jar


        QueryRequest storyRequest = new QueryRequest("HierarchicalRequirement");
        storyRequest.setFetch(new Fetch("Name","Owner","UserName", "EmailAddress"));
        storyRequest.setLimit(1000);
        storyRequest.setScopedDown(false);
        storyRequest.setScopedUp(false);
        storyRequest.setWorkspace(workspaceRef);
        storyRequest.setProject(projectRef);
        storyRequest.setQueryFilter(new QueryFilter("FormattedID", "=", "US16"));

        QueryResponse storyQueryResponse = restApi.query(storyRequest);
        JsonObject storyJsonObject = storyQueryResponse.getResults().get(0).getAsJsonObject();

        System.out.println("Name: " + storyJsonObject.get("Name"));

        JsonObject userObject = storyJsonObject.get("Owner").getAsJsonObject().getAsJsonObject();
        System.out.println(userObject.get("UserName"));
        System.out.println(userObject.get("EmailAddress")); 
    }
}