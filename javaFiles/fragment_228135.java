SourceCredentials sourceCredentials = new SourceCredentials();

//Create SiteIDs KvmSerializable object
SiteIDs siteIDS = new SiteIDS();
siteIDS.setInt(1111)

//Setters
sourceCredentials.setSourceName("sourcename");
sourceCredentials.setPassword("password=");
sourceCredentials.setSiteIDS(siteIDS);


request.addProperty("SourceCredentials", sourceCredentials);