public class RemoteAWSS3ClientManagerImpl implements AWSS3ClientManager {
private static Logger logger = LoggerFactory.getLogger(RemoteAWSS3ClientManagerImpl.class);
private PriorityCodeSourcesRoutesProperties priorityCodeSourcesRoutesProperties;
private SimpleRegistry registry = new SimpleRegistry();
private CamelContext camelContext;

public RemoteAWSS3ClientManagerImpl(PriorityCodeSourcesRoutesProperties priorityCodeSourcesRoutesProperties) {
    this.priorityCodeSourcesRoutesProperties = priorityCodeSourcesRoutesProperties;
    registry.put("amazonS3Client", getS3Client());
    camelContext = new DefaultCamelContext(registry);
    logger.info("Creating an AWS S3 client for a remote instance (normal for ec2s).");
}

private AmazonS3 getS3Client() {
    try {
        logger.info("Attempting to create an AWS S3 client with IAM role's temporary credentials.");
        return AmazonS3ClientBuilder.standard()
                                    .withCredentials(new InstanceProfileCredentialsProvider(false))
                                    .withRegion(Regions.US_WEST_2)
                                    .build();
    } catch (RuntimeException ex) {
        logger.error("Could not create AWS S3 client with the given credentials from the instance. "
                     + "The default credential chain was used to create the AWS S3 client. "
                     + ex.toString());
    }
    return null;
}

public Endpoint getIncomingAWSEndpoint(final String incomingAWSBucket, final String region,
        final String fileNameToSaveAndDownload) {
    return camelContext.getEndpoint(
            "aws-s3://" + incomingAWSBucket + "?" + "amazonS3Client=#amazonS3Client"
            + "&region=" + region + "&deleteAfterRead=false" + "&prefix=" + fileNameToSaveAndDownload);
}

public Endpoint getOutgoingLocalEndpoint(final String outgoingEndpointDirectory,
        final String fileNameToSaveAndDownload) {
    return camelContext.getEndpoint(
            "file://" + outgoingEndpointDirectory + "?" + "fileName="
            + fileNameToSaveAndDownload + "&readLock=markerFile");
}

}