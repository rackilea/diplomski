ClientConfig config = new ClientConfig();
Application application = // create application that contains ImageProvider 
config.applications(application);
RestClient restClient = new RestClient(config);
URI uri = // uri to server
Image image = // create image
restClient.resource(uri).contentType("image/jpeg").post(image);