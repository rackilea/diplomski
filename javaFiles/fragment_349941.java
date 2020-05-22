public class RestExample_AddChangesetToUserStory {

    public static void main(String[] args) throws URISyntaxException, IOException {

        // Rally parameters
        String rallyURL = new String("https://rally1.rallydev.com");
        String wsapiVersion = new String("1.36");
        String userName = new String("user@company.com");
        String userPassword = new String("password");
        String applicationName = new String("RestExample_AddChangeSetToStory");

        // Workspace and Project refs
        String workspaceRef = new String("/workspace/12345678910");
        String projectRef = new String("/project/12345678911");

        // Create and configure a new instance of RallyRestApi
        RallyRestApi restApi = new RallyRestApi(
                                                    new URI(rallyURL), 
                                                    userName,
                                                    userPassword
                                                );
        restApi.setWsapiVersion(wsapiVersion);
        restApi.setApplicationName(applicationName);

        // Changeset Owner Username
        String changesetOwner = new String("changesetowner@company.com");

        // SCM Repository Name
        String scmRepositoryName = new String("SVNRepository");

        // FormattedID of Artifact to associate to
        String storyFormattedID = "US14";

        //Read User
        QueryRequest userRequest = new QueryRequest("User");
        userRequest.setFetch(new Fetch("UserName", "Subscription", "DisplayName"));
        userRequest.setQueryFilter(new QueryFilter("UserName", "=", changesetOwner));
        QueryResponse userQueryResponse = restApi.query(userRequest);
        JsonArray userQueryResults = userQueryResponse.getResults();
        JsonElement userQueryElement = userQueryResults.get(0);
        JsonObject userQueryObject = userQueryElement.getAsJsonObject();        
        String userRef = userQueryObject.get("_ref").toString();
        System.out.println("userRef: " + userRef);

        // Query for SCMRepository which pertains to this ChangeSet
        QueryRequest scmRequest = new QueryRequest("SCMRepository");
        scmRequest.setFetch(new Fetch("ObjectID","Name","SCMType"));
        scmRequest.setWorkspace(workspaceRef);
        scmRequest.setProject(projectRef);
        scmRequest.setQueryFilter(new QueryFilter("Name", "=", scmRepositoryName));
        QueryResponse scmQueryResponse = restApi.query(scmRequest);
        JsonObject scmJsonObject = scmQueryResponse.getResults().get(0).getAsJsonObject();
        String scmRef = scmJsonObject.get("_ref").toString();
        System.out.println("scmRef: " + scmRef);

        // Query for Story to which we want to add ChangeSet
        QueryRequest storyRequest = new QueryRequest("HierarchicalRequirement");
        storyRequest.setFetch(new Fetch("FormattedID","Name","Changesets"));
        storyRequest.setQueryFilter(new QueryFilter("FormattedID", "=", storyFormattedID));
        storyRequest.setWorkspace(workspaceRef);
        storyRequest.setProject(projectRef);
        QueryResponse storyQueryResponse = restApi.query(storyRequest);
        JsonObject storyJsonObject = storyQueryResponse.getResults().get(0).getAsJsonObject();
        JsonArray changesetJsonArray = storyJsonObject.getAsJsonArray("Changesets");
        String storyRef = storyJsonObject.get("_ref").toString();

        System.out.println("storyRef: " + storyRef);
        System.out.println("Number of existing Changesets: " + changesetJsonArray.size());

        // Setup JsonObject for new Changeset
        JsonObject newChangeset = new JsonObject();
        newChangeset.addProperty("SCMRepository", scmRef);
        newChangeset.addProperty("Author", userRef);
        newChangeset.addProperty("Revision", "2451");
        newChangeset.addProperty("Uri", "https://svnrepo.company.com:8001");
        newChangeset.addProperty("CommitTimestamp", "2012-07-18T18:00Z");
        // Artifacts JsonArray for collection on Changeset
        JsonArray artifactsJsonArray = new JsonArray();
        artifactsJsonArray.add(storyJsonObject);

        // Associate newChangeset to Story artifact
        newChangeset.add("Artifacts", artifactsJsonArray);

        try {

            //Create the Changeset
            System.out.println("Creating Changeset...");

            CreateRequest createRequest = new CreateRequest("Changeset", newChangeset);
            System.out.println(createRequest.getBody());
            CreateResponse createResponse = restApi.create(createRequest);

            if (createResponse.wasSuccessful()) {
                System.out.println(String.format("Created %s", createResponse.getObject().get("_ref").getAsString()));
                String[] warningList;
                warningList = createResponse.getWarnings();
                for (int i=0;i<warningList.length;i++) {
                    System.out.println(warningList[i]);
                }
            } else {
                String[] errorList;
                errorList = createResponse.getErrors();
                for (int i=0;i<errorList.length;i++) {
                    System.out.println(errorList[i]);
                }
            }

        } finally {
            //Release all resources
            restApi.close();
        }
    }
}