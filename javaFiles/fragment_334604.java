public class RestExample_AddTagsToTestCase {

    public static void main(String[] args) throws URISyntaxException, IOException {

        // Create and configure a new instance of RallyRestApi
        // Connection parameters
        String rallyURL = "https://rally1.rallydev.com";
        String wsapiVersion = "1.34";
        String applicationName = "RestExample_AddTagsToTestCase";

        // Credentials
        String userName = "user@company.com";
        String userPassword = "password";

        RallyRestApi restApi = new RallyRestApi(
                new URI(rallyURL),
                userName,
                userPassword);
        restApi.setWsapiVersion(wsapiVersion);
        restApi.setApplicationName(applicationName);

        // User settings
        String testerUserName = "tester@company.com";

        // Workspace and Project Settings
        String myWorkspace = "My Workspace";
        String myProject = "My Project";

        // FormattedID of Existing Test Case to Query
        String existTestCaseFormattedID = "TC172";

        // Tag Names of Interest
        String tagNameAlpine = "Alpine";
        String tagNameMontane = "Montane";

        //Read User
        QueryRequest userRequest = new QueryRequest("User");
        userRequest.setFetch(new Fetch("UserName", "Subscription", "DisplayName"));
        userRequest.setQueryFilter(new QueryFilter("UserName", "=", testerUserName));
        QueryResponse userQueryResponse = restApi.query(userRequest);
        JsonArray userQueryResults = userQueryResponse.getResults();
        JsonElement userQueryElement = userQueryResults.get(0);
        JsonObject userQueryObject = userQueryElement.getAsJsonObject();
        String userRef = userQueryObject.get("_ref").toString();

        // Get reference to Workspace of interest
        QueryRequest workspaceRequest = new QueryRequest("Workspace");
        workspaceRequest.setFetch(new Fetch("Name", "Owner", "Projects"));
        workspaceRequest.setQueryFilter(new QueryFilter("Name", "=", myWorkspace));
        QueryResponse workspaceQueryResponse = restApi.query(workspaceRequest);
        String workspaceRef = workspaceQueryResponse.getResults().get(0).getAsJsonObject().get("_ref").toString();

        // Get reference to Project of interest
        QueryRequest projectRequest = new QueryRequest("Project");
        projectRequest.setFetch(new Fetch("Name", "Owner", "Projects"));
        projectRequest.setQueryFilter(new QueryFilter("Name", "=", myProject));
        QueryResponse projectQueryResponse = restApi.query(projectRequest);
        String projectRef = projectQueryResponse.getResults().get(0).getAsJsonObject().get("_ref").toString();

        // Get reference to Tag(s) of interest
        QueryRequest tagRequest = new QueryRequest("Tag");
        tagRequest.setFetch(new Fetch("Name"));

        // Look for Tag named "Alpine"
        tagRequest.setQueryFilter(new QueryFilter("Name", "=", tagNameAlpine));
        QueryResponse tagQueryResponse = restApi.query(tagRequest);
        JsonObject tagAlpineJsonObject = tagQueryResponse.getResults().get(0).getAsJsonObject();
        JsonElement tagAlpine = tagQueryResponse.getResults().get(0).getAsJsonObject();
        String tagAlpineRef = tagAlpineJsonObject.get("_ref").toString();

        // Look for a second Tag named "Montane"
        tagRequest.setQueryFilter(new QueryFilter("Name", "=", tagNameMontane));
        tagQueryResponse = restApi.query(tagRequest);
        JsonObject tagMontaneJsonObject = tagQueryResponse.getResults().get(0).getAsJsonObject();
        JsonElement tagMontane = tagQueryResponse.getResults().get(0).getAsJsonObject();
        String tagMontaneRef = tagMontaneJsonObject.get("_ref").toString();

        // Query for existing Test Case
        QueryRequest  existTestCaseRequest = new QueryRequest("TestCase");
        existTestCaseRequest.setFetch(new Fetch("FormattedID","Name","Tags"));
        existTestCaseRequest.setQueryFilter(new QueryFilter("FormattedID", "=", existTestCaseFormattedID));
        QueryResponse testCaseQueryResponse = restApi.query(existTestCaseRequest);
        JsonObject existTestCaseJsonObject = testCaseQueryResponse.getResults().get(0).getAsJsonObject();
        String existTestCaseRef = testCaseQueryResponse.getResults().get(0).getAsJsonObject().get("_ref").toString();
        JsonArray existTagsJsonArray = (JsonArray) testCaseQueryResponse.getResults().get(0).getAsJsonObject().get("Tags");               

        // Update Tags on Existing Test Case
        try {

            // Add additional Tag to Existing Test Case's Tag Collection
            existTagsJsonArray.add(tagMontane);

            //Add Tag
            System.out.println("\nUpdating Existing Test Case's tags...");
            JsonObject updateExistTestCase = new JsonObject();

            updateExistTestCase.add("Tags", existTagsJsonArray);
            UpdateRequest updateExistTestCaseRequest = new UpdateRequest(existTestCaseRef, updateExistTestCase);
            UpdateResponse updateExistTestCaseResponse = restApi.update(updateExistTestCaseRequest);

            if (updateExistTestCaseResponse.wasSuccessful()) {
                System.out.println("Updated Test Case with new Tags");
            } else {
                String[] updateExistTestCaseErrors;
                updateExistTestCaseErrors = updateExistTestCaseResponse.getErrors();
                System.out.println("Error occurred updating Test Case: ");
                for (int i=0; i<updateExistTestCaseErrors.length;i++) {
                    System.out.println(updateExistTestCaseErrors[i]);
                }                   
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while updating Tags on existing Test Case: ");
            e.printStackTrace();            
        }

        // Create a New Test Case and Add Tags to it
        try {

            //Create a Test Case                    
            System.out.println("Creating Test Case...");
            JsonObject newTestCase = new JsonObject();
            newTestCase.addProperty("Name", "TC0400-1200: SeleniumGroup004");
            newTestCase.addProperty("Method", "Automated");
            newTestCase.addProperty("Type", "Performance"); 
            newTestCase.addProperty("Workspace", workspaceRef);
            newTestCase.addProperty("Project", projectRef);
            newTestCase.addProperty("Owner", userRef);  

            CreateRequest createRequest = new CreateRequest("testcase", newTestCase);
            CreateResponse createResponse = restApi.create(createRequest);            

            if (createResponse.wasSuccessful()) {

                System.out.println(String.format("Created %s", createResponse.getObject().get("_ref").getAsString()));          

                //Read Test Case
                String newTestCaseRef = Ref.getRelativeRef(createResponse.getObject().get("_ref").getAsString());
                System.out.println(String.format("\nReading Test Case %s...", newTestCaseRef));
                GetRequest getRequest = new GetRequest(newTestCaseRef);
                getRequest.setFetch(new Fetch("FormattedID", "Name", "Tags"));
                GetResponse getResponse = restApi.get(getRequest);
                JsonObject obj = getResponse.getObject();
                System.out.println(String.format("Read Test Case. FormattedID = %s, Name = %s",
                        obj.get("FormattedID").getAsString(), obj.get("Name").getAsString()));

                // JsonArray for Tags collection on Test Case
                JsonArray newTagsJsonArray = new JsonArray();
                newTagsJsonArray.add(tagAlpine);
                newTagsJsonArray.add(tagMontane);

                //Add Tag
                System.out.println("\nUpdating Test Case tags...");
                JsonObject updatedTestCase = new JsonObject();

                updatedTestCase.add("Tags", newTagsJsonArray);
                UpdateRequest updateRequest = new UpdateRequest(newTestCaseRef, updatedTestCase);
                UpdateResponse updateResponse = restApi.update(updateRequest);

                if (updateResponse.wasSuccessful()) {
                    System.out.println("Updated Test Case with new Tags");
                } else {
                    String[] updateErrors;
                    updateErrors = updateResponse.getErrors();
                    System.out.println("Error occurred updating Test Case: ");
                    for (int i=0; i<updateErrors.length;i++) {
                        System.out.println(updateErrors[i]);
                    }                   
                }   

            } else {
                String[] createErrors;
                createErrors = createResponse.getErrors();
                System.out.println("Error occurred creating Test Case: ");
                for (int i=0; i<createErrors.length;i++) {
                    System.out.println(createErrors[i]);
                }
            }

        } finally {
            //Release all resources
            restApi.close();
        }                
    }
}