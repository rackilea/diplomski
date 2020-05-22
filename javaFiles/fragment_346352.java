// Configure the Client that you'll use to make search requests
string queryUrl = @"http://search-<domainname>-xxxxxxxxxxxxxxxxxxxxxxxxxx.us-east-1.cloudsearch.amazonaws.com";
AmazonCloudSearchDomainClient searchClient = new AmazonCloudSearchDomainClient(queryUrl);

// Configure a search request with your query
SearchRequest searchRequest = new SearchRequest();
searchRequest.Query = "potato";
// TODO Set your other params like parser, suggester, etc

// Submit your request via the client and get back a response containing search results
SearchResponse searchResponse = searchClient.Search(searchRequest);