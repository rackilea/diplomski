private static final String accountName = "<account-name>";
private static final String accountKey = "<account-key>";
private static final String connectionStringTemplate = "DefaultEndpointsProtocol=http;AccountName=%s;AccountKey=%s";
private static final String containerName = "<block-blob-container-name>";
private static final String blobFileName = "<blob-file-name>";

public static void main(String[] args) throws InvalidKeyException, URISyntaxException, StorageException {
    String connectionString = String.format(connectionStringTemplate, accountName, accountKey);
    CloudStorageAccount account = CloudStorageAccount.parse(connectionString);
    CloudBlobClient blobClient = account.createCloudBlobClient();
    /*
     * Enable CORS
     */
    // CORS should be enabled once at service startup
    // Given a BlobClient, download the current Service Properties
    ServiceProperties blobServiceProperties = blobClient.downloadServiceProperties();
    // Enable and Configure CORS
    CorsProperties cors = new CorsProperties();
    CorsRule corsRule = new CorsRule();
    List<String> allowedHeaders = new ArrayList<String>();
    allowedHeaders.add("*");
    EnumSet<CorsHttpMethods> allowedMethods = EnumSet.of(CorsHttpMethods.PUT, CorsHttpMethods.GET, CorsHttpMethods.HEAD, CorsHttpMethods.POST);
    System.out.println(Arrays.toString(allowedMethods.toArray()));
    List<String> allowedOrigins = new ArrayList<String>();
    allowedOrigins.add("*");
    List<String> exposedHeaders = new ArrayList<String>();
    exposedHeaders.add("*");
    int maxAgeInSeconds = 1800;
    corsRule.setAllowedHeaders(allowedHeaders);
    corsRule.setAllowedMethods(allowedMethods);
    corsRule.setAllowedOrigins(allowedOrigins);
    corsRule.setExposedHeaders(exposedHeaders);
    corsRule.setMaxAgeInSeconds(maxAgeInSeconds);
    cors.getCorsRules().add(corsRule);
    blobServiceProperties.setCors(cors);
    // Commit the CORS changes into the Service Properties
    blobClient.uploadServiceProperties(blobServiceProperties);
    /*
     * Generate the SAS for the uploading url
     */
    CloudBlobContainer container = blobClient.getContainerReference(containerName);
    CloudBlockBlob blockBlob = container.getBlockBlobReference(blobFileName);
    SharedAccessBlobPolicy sharedAccessBlobPolicy = new SharedAccessBlobPolicy();
    GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(new Date());
    sharedAccessBlobPolicy.setSharedAccessStartTime(calendar.getTime());
    calendar.add(Calendar.HOUR, 1);
    sharedAccessBlobPolicy.setSharedAccessExpiryTime(calendar.getTime());
    sharedAccessBlobPolicy.setPermissions(EnumSet.of(SharedAccessBlobPermissions.WRITE));
    String sas = blockBlob.generateSharedAccessSignature(sharedAccessBlobPolicy, null);
    System.out.println(sas);
    String blobUploadSASURL = String.format("https://%s.blob.core.windows.net/%s/%s?%s", accountName, containerName, blobFileName, sas);
    System.out.println(blobUploadSASURL);
}