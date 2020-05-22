useTasksAPI(String accessToken) {
  // Setting up the Tasks API Service
  HttpTransport transport = AndroidHttp.newCompatibleTransport();
  AccessProtectedResource accessProtectedResource = new GoogleAccessProtectedResource(accessToken);
  Tasks service = new Tasks(transport, accessProtectedResource, new JacksonFactory());
  service.accessKey = INSERT_YOUR_API_KEY;
  service.setApplicationName("Google-TasksSample/1.0");

  // TODO: now use the service to query the Tasks API
}