public class GetTestCaseResults {

    public static void main(String[] args) throws Exception {

        String host = "https://rally1.rallydev.com";
        String applicationName = "Example: get Results of TestCase";
        String projectRef = "/project/12345"; //user your own project OID
        String apiKey = "_abc123";
        RallyRestApi restApi = null;
        try {
            restApi = new RallyRestApi(new URI(host),apiKey);
            restApi.setApplicationName(applicationName);
            QueryRequest testCaseRequest = new QueryRequest("TestCase");
            testCaseRequest.setProject(projectRef);

            testCaseRequest.setFetch(new Fetch(new String[] {"FormattedID","Results","LastVerdict"}));
            testCaseRequest.setQueryFilter(new QueryFilter("FormattedID", "=", "TC3"));
            //testCaseRequest.setLimit(25000);
            testCaseRequest.setScopedDown(false);
            testCaseRequest.setScopedUp(false);

            QueryResponse testCaseResponse = restApi.query(testCaseRequest);
            System.out.println("Successful: " + testCaseResponse.wasSuccessful());
            System.out.println("Size: " + testCaseResponse.getTotalResultCount());
            int totalResults = 0;
            for (int i=0; i<testCaseResponse.getResults().size();i++){
                JsonObject testCaseJsonObject = testCaseResponse.getResults().get(i).getAsJsonObject();
                System.out.println("Name: " + testCaseJsonObject.get("Name") + " FormattedID: " + testCaseJsonObject.get("FormattedID") + " LastVerdict: " + testCaseJsonObject.get("LastVerdict"));
                int numberOfResults = testCaseJsonObject.getAsJsonObject("Results").get("Count").getAsInt();

                if(numberOfResults > 0) {
                    totalResults += numberOfResults;
                    QueryRequest resultsRequest = new QueryRequest(testCaseJsonObject.getAsJsonObject("Results"));
                    resultsRequest.setFetch(new Fetch("Verdict","Date"));
                    //load the collection
                    JsonArray results = restApi.query(resultsRequest).getResults();
                    for (int j=0;j<numberOfResults;j++){
                        System.out.println("Name: " + results.get(j).getAsJsonObject().get("Verdict") + results.get(j).getAsJsonObject().get("Date").getAsString());
                    }
                }
            }
            System.out.println("Total number of results: " + totalResults);
        } finally {
            if (restApi != null) {
                restApi.close();
            }
        }
    }
}