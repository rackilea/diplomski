SourceCredentials sourceCredentials = new SourceCredentials();

    //Create SiteIDs KvmSerializable object
      SiteIDs siteIDS = new SiteIDS();
      List<Integer> ints = new ArrayList<Integer>();
      ints.add(1111); //add one o more ints
      siteIDS.setInts(ints);
   //Setters
      sourceCredentials.setSourceName("sourcename");
      sourceCredentials.setPassword("password=");
      sourceCredentials.setSiteIDS(siteIDS);


      request.addProperty("SourceCredentials", sourceCredentials);