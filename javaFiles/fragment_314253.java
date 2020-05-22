String payload = "payload={\"channel\": \"#channel_name\", \"text\": \"This is posted "
            + "to #ewe_gps_abacus_notif and comes from a bot named change-alert.\"}";

    StringEntity entity = new StringEntity(payload,
            ContentType.APPLICATION_FORM_URLENCODED);

    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost request = new HttpPost(slackWebhook);
    request.setEntity(entity);

    HttpResponse response = null;
    try {
        response = httpClient.execute(request);
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(response.getStatusLine().getStatusCode());