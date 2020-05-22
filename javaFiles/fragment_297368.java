// create the REST template
RestTemplate rest = new RestTemplate()

// define URL to fetch
String url = "http://search-testing-xxxxxxxxxxxxx.ap-xxxxxxx-1.es.amazonaws.com/inventory/parent/7874";

// make the request
ResponseEntity<String> resp = rest.exchange(url, HttpMethod.GET, null, String.class)

// retrieve the JSON response
String body = resp.getBody();