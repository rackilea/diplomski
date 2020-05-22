int count = 1;
String jsonInputData = "{ "+
                "  \"accountEnabled\": true," + 
                "  \"displayName\": \"TestUserFromEclipse" +count+"\"," + 
                "  \"mailNickname\": \"mailNickname-value\"," +
                "  \"country\": \"IN\"," +
                "  \"userPrincipalName\": \"eclipseuser"+count+"@alandonaldgmail.onmicrosoft.com\"," + 
                "  \"passwordProfile\" : {" + 
                "    \"forceChangePasswordNextSignIn\": false," + 
                "    \"password\": \"Sigma@123\"" + 
                "  }" + 
                "}";

    HttpPost post = null;
        try {
            String url = "https://graph.microsoft.com/v1.0/users";
            StringEntity s = new StringEntity(jsonInputData);
            HttpClient client = HttpClientBuilder.create().build();
            post = new HttpPost(url);

            // add header
            post.setHeader("Content-Type", "application/json");
            post.setHeader("Authorization", "Bearer " + accessToken);
            post.setEntity(s);

            HttpResponse response = client.execute(post);
            System.out.println("Response Code : " 
                        + response.getStatusLine().getStatusCode());
        } finally {
            post.releaseConnection();
        }