//Create a new authorized API client
    Drive service = new Drive.Builder(httpTransport, jsonFactory, credential).build();

    //Insert a file  
    File body = new File();
    body.setTitle("My document");
    body.setDescription("A test document");
    body.setMimeType("text/plain");

    java.io.File fileContent = new java.io.File("document.txt");
    FileContent mediaContent = new FileContent("text/plain", fileContent);

    File file = service.files().insert(body, mediaContent).execute();