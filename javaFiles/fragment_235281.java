String url = buildUrl("jira/rest/api/2/search");
    String query = "project = XXXX AND issuetype = Test AND text ~ \"" + testId + "\"";

JSONArray fields = new JSONArray();
fields.put("id");
fields.put("key");
fields.put("summary");

JSONObject reqObj = new JSONObject();
reqObj.put("jql", query);
reqObj.put("startAt", 0);
reqObj.put("maxResults", 15);
reqObj.put("fields", fields);

String requestBody = reqObj.toString();
logger.debug("Request body: " + requestBody);

HttpURLConnection conn = httpPost(url, null, null, requestBody);
logger.debug("HTTP response code: " + conn.getResponseCode());
String response = IOUtils.toString(conn.getInputStream());
logger.debug("HTTP res content: " + response);