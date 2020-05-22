// Create client with settings
  final WebClient webClient = new WebClient();
  webClient.setTimeout(5000);

  // Create web request
  WebRequest requestSettings = new WebRequest(new URL("http://www.amazon.com/s/ref=nb_sb_noss"), HttpMethod.POST);

  // Set the request parameters
  requestSettings.setRequestParameters(new ArrayList());
  requestSettings.getRequestParameters().add(new NameValuePair("field-keywords", "Doctor Who"));

  Page page = webClient.getPage(requestSettings);
  page.getWebResponse().getStatusCode();