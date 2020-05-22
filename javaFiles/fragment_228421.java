RestTemplate restTemplate = new RestTemplate();

  // Prepare acceptable media type
  List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
  acceptableMediaTypes.add(MediaType.APPLICATION_XML); // Set what you need

  // Prepare header
  HttpHeaders headers = new HttpHeaders();
  headers.setAccept(acceptableMediaTypes);
  HttpEntity<Person> entity = new HttpEntity<Person>(headers);

  // Send the request as GET
  try {
      ResponseEntity<PersonList> result = restTemplate.exchange("http://localhost:8080/Library/rest/person/1", HttpMethod.GET, entity, PersonList.class);
      // Add to model
      model.addAttribute("persons", result.getBody().getData());

  } catch (Exception e) {
      logger.error(e);
  }