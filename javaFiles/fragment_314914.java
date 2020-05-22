SchoologyRequestHandler schoology = new OAuthSchoologyRequestHandler(new BasicOAuthResourceLocator(DISTRICT_PREFIX), API_KEY, API_SECRET);

SchoologyResponseBody response = schoology.get("sections/123456789").requireSuccess().getBody();

System.out.println(response.getRawData()); // JSON string

SchoologyNode node = response.parse();
System.out.println(node.get("JSON_KEY").get(1).asString()); // index 1 of some JSON_KEY property