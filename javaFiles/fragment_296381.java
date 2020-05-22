// Build the StructuredQueryDefinition 
// from StructuredQueryBuilder
StructuredQueryDefinition builtSQ = queryBuilder.term("one");
String XML_OPTIONS = 
     "<options xmlns=\"http://marklogic.com/appservices/search\">" +
        " <constraint name=\"artist\"> " +
        " <range type = \"xs:string\" " +
               " collation = \"http://marklogic.com/collation/en/S1/AS/T00BB\"> " + 
        " <element ns = \"http://marklogic.com/MLU/top-songs\" name=\"artist\"/>" + 
        " <facet-option>descending</facet=option> " +
        " <facet-option>limit=30</facet=option> " +
     "</options>";
// Create a QueryManager
QueryManager qm = client.newQueryManager();
StructuredWriteHandle queryHandle = new StringHandle().with(
        "<search xmlns=\"http://marklogic.com/appservices/search\">" +
            builtSQ.serialize() + 
            XML_OPTIONS +
        "</search>").withFormat(Format.XML)
RawCombinedQueryDefinition query = qm.newRawCombinedQueryDefinition(queryHandle);
// Perform the search
SearchHandle results = qm.search(query, new SearchHandle());