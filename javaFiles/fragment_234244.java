{
    InputStream input = new FileInputStream(getPerforceDetails);
    Properties prop = new Properties();
    prop.load(input);

    url = prop.getProperty("url"); //ex: perforce.xxx.xxxxxxx.com:port#
    repo = prop.getProperty("repo"); //ex: //depot/xxx/xxxx/apps/...
    username = prop.getProperty("username");
    password = prop.getProperty("password"));

    final String url = IServerAddress.Protocol.P4JAVA.toString() + "://" + serverUri;

    server = ServerFactory.getServer(url, null);
    server.connect();
    server.setUserName(username);       
    server.login(password);

    IServerInfo info = server.getServerInfo();
    System.out.println( "Server Info \n" + info);
    fileList = server.getDepotFiles(FileSpecBuilder.makeFileSpecList(new String[] {prop.getProperty("repo")}), false);
    //comment above line if you have only few files to clones and refer blog mentioned.

    // Creating new temporary client
    IClient tempClient = new Client();          
    tempClient.setName("tempClient" + UUID.randomUUID().toString().replace("-", ""));
    tempClient.setRoot("c:/tempP4"); 
    tempClient.setServer(server);

    // Setting the client as the current one for the server
    server.setCurrentClient(tempClient);

    // Creating Client View entry
    ClientViewMapping tempMappingEntry = new ClientViewMapping();

    // Setting up the mapping properties
    tempMappingEntry.setLeft("//depot/gxxxx/hxxxxxx/ixxxx/...");
    tempMappingEntry.setRight("//" + tempClient.getName() + "/...");
    tempMappingEntry.setType(EntryType.INCLUDE);     
    // Creating Client view
    ClientView tempClientView = new ClientView();
    // Attaching client view entry to client view
    tempClientView.addEntry(tempMappingEntry);
    tempClient.setClientView(tempClientView);
    // Registering the new client on the server
    System.out.println(server.createClient(tempClient));
    fileList = server.getDepotFiles(FileSpecBuilder.makeFileSpecList(new String[] {prop.getProperty("repo")}), false);
    try{
    // Forming the FileSpec collection to be synced-up
          List<IFileSpec> fileSpecsSet =     FileSpecBuilder.makeFileSpecList(pathsUnderDepot);
          // Syncing up the client
          //tempClient.sync(FileSpecBuilder.getValidFileSpecs(fileSpecsSet), true, false, false, false);
          //uncomment above line, n comment below if you are cloning only few files                 
          tempClient.sync(fileList, true, false, false, false);
    }finally{
        // Removing the temporary client from the server
          System.out.println(server.deleteClient(tempClient.getName(), false));
   }
 }