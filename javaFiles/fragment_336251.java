String xmlContent = "<request attribute="attributeValue"><content contentAttribute="plain"/></request>";

URI uri = UriComponentsBuilder.fromHttpUrl("http://ill-service.com/plain.cgi")
    //This part set the query param as a full encoded value, not as query value encoded
    .queryParam("XML_DATA", UriUtils.encode(xmlContent, "UTF-8"))
    //The build(true) indicate to the builder that the Uri is already encoded
    .build(true).toUri();

String responseStr = restTemplate.getForObject(uri ,String.class)