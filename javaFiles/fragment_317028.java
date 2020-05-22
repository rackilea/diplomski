Discovery discovery = new Discovery("2017-08-01");
discovery.setEndPoint("https://gateway.watsonplatform.net/discovery/api");                             
discovery.setUsernameAndPassword("feeb4a95-xxxx-xxxx-xxxx-4d94c98b2b24", "KQc6G5nK6HrD");
String environmentId = "59d0fa32-xxxx-xxxx-xxxx-cf98a8cdc52e";
String collectionId = "49a82bd4-xxxx-xxxx-xxxx-900b7378ff35";
File f = new File("/Users/xxx/Desktop/myDoc.json");
Path path = Paths.get(f.getPath());
InputStream documentStream = new ByteArrayInputStream(Files.readAllBytes(path));

//Create
CreateDocumentRequest.Builder builder = new CreateDocumentRequest.Builder(environmentId, collectionId);
builder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
CreateDocumentResponse createResponse = discovery.createDocument(builder.build()).execute();
//Retrieve  (You can get documentId here)
QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
System.out.println(queryResponse.toString());
//Delete
String documentId = "d1059598-xxxx-xxxx-xxxx-b65a1f3334d8";
DeleteDocumentRequest deleteRequest = new DeleteDocumentRequest.Builder(environmentId, collectionId, documentId).build();
DeleteDocumentResponse deleteResponse = discovery.deleteDocument(deleteRequest).execute();