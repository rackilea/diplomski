public List<News> getTopStories() throws Exception {

    List<News> topStories = new ArrayList<>();
    RestTemplate restTemplate = new RestTemplate();

    String getUrl = "https://api.nytimes.com/svc/topstories/v2/science.json?api-key=" + apiKey;

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<String>(headers);
    ResponseEntity<Map> newsList = restTemplate.exchange(getUrl, HttpMethod.GET, entity, Map.class);
    JSONObject jsonObject;

    if (newsList.getStatusCode() == HttpStatus.OK) {

        jsonObject = new JSONObject(newsList.getBody());
        JSONArray jsonArray = jsonObject.getJSONArray("results");

        for(int i=0; i<jsonArray.length(); i++) {
            News news = new News();
            news.setTitle(jsonArray.getJSONObject(i).get("title").toString());
            news.setSection(jsonArray.getJSONObject(i).get("section").toString());
            topStories.add(news);
        }
    }
    // this is only returning the last index of the jsonArray (pretty sure I am suppose to return all to in my URL). Can't seem to come up with the logic to do that.
    return topStories; 
}