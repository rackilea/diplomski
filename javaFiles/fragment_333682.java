public class RestExample_QueryWorkspacesAndProjects {

            public static void main(String[] args) throws URISyntaxException, IOException {

                    // Create and configure a new instance of RallyRestApi
                    // Connection parameters
                    String rallyURL = "https://rally1.rallydev.com";
                    String wsapiVersion = "1.43";
                    String applicationName = "RestExample_QueryWorkspacesAndProjects";

                    // Credentials
                    String userName = "user@company.com";
                    String userPassword = "topsecret";

                    RallyRestApi restApi = new RallyRestApi(
                            new URI(rallyURL),
                            userName,
                            userPassword);
                    restApi.setWsapiVersion(wsapiVersion);
                    restApi.setApplicationName(applicationName);      

                    //Read Subscription
                    QueryRequest subscriptionRequest = new QueryRequest("Subscriptions");
                    subscriptionRequest.setFetch(new Fetch("Name", "SubscriptionID", "Workspaces", "Name"));

                    QueryResponse subscriptionQueryResponse = restApi.query(subscriptionRequest);
                    JsonArray subscriptionQueryResults = subscriptionQueryResponse.getResults();
                    JsonElement subscriptionQueryElement = subscriptionQueryResults.get(0);
                    JsonObject subscriptionQueryObject = subscriptionQueryElement.getAsJsonObject();
                    String subID = subscriptionQueryObject.get("SubscriptionID").toString();

                    System.out.println("Read Subscription: " + subID);

                    // Grab Workspaces Collection
                    JsonArray myWorkspaces = subscriptionQueryObject.get("Workspaces").getAsJsonArray();

                    // Initialize Project counter
                    int numberProjects = 0;

                    for (int i=0; i<myWorkspaces.size(); i++) {
                            JsonObject workspaceObject = myWorkspaces.get(i).getAsJsonObject();
                            String workspaceRef = workspaceObject.get("_ref").getAsString();                

                        GetRequest workspaceRequest = new GetRequest(workspaceRef);
                        workspaceRequest.setFetch(new Fetch("Name", "Projects"));
                        GetResponse workspaceResponse = restApi.get(workspaceRequest);
                        JsonObject workspaceObj = workspaceResponse.getObject();

                        String workspaceName = workspaceObj.get("Name").getAsString();
                        System.out.printf("Workspace %d ==> %s\n", i, workspaceName);

                        JsonArray myProjects = workspaceObj.get("Projects").getAsJsonArray();

                        for (int j=0; j<myProjects.size(); j++)
                        {
                            JsonObject projectObject = myProjects.get(j).getAsJsonObject();
                            String projectRef = projectObject.get("_ref").getAsString();
                            GetRequest projectRequest = new GetRequest(projectRef);
                            projectRequest.setFetch(new Fetch("Name"));
                            GetResponse projectResponse = restApi.get(projectRequest);              

                            JsonObject projectObj = projectResponse.getObject();
                            String projectName = projectObj.get("Name").getAsString();
                            System.out.printf("==> Project %d ==> %s\n", j, projectName);

                            numberProjects++;
                        }
                    }

                    String numberWorkspacesStr =  String.valueOf(myWorkspaces.size());
                    String numberProjectsStr = String.valueOf(numberProjects);

                    System.out.println("Total Workspaces: " + numberWorkspacesStr);
                    System.out.println("Total Projects: " + numberProjectsStr);

                    restApi.close();
            }