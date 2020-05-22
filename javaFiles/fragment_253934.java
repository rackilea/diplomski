String yourJsonString = ...

StringRequestEntity requestEntity = new StringRequestEntity(
    yourJsonString,
    "application/json",
    "UTF-8");

PostMethod postMethod = new PostMethod("http://couchdb.server/database");
postMethod.setRequestEntity(requestEntity);

int statusCode = httpClient.executeMethod(postMethod);