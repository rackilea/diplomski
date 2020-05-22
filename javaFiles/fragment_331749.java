Tweet tweet = new Tweet();
   tweet.setId("1234");
   tweet.setMessage("message");

   IndexRequest indexRequest = new IndexRequest("twitter","tweet", tweet.getId());
   indexRequest.source(new Gson().toJson(tweet));
   IndexResponse response = client.index(indexRequest).actionGet();