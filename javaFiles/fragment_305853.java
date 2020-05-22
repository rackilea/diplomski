public static DynamoDB getDynamoDBConnection()
        throws ApplicationSpecificException {   
    try {
        return new DynamoDB(new AmazonDynamoDBClient(
                                    new ProfileCredentialsProvider()));
    } catch(AmazonServiceException ase) {
        slf4jLogger.error(ase.getMessage());
        slf4jLogger.error(ase.getStackTrace());
        slf4jLogger.error(ase);
        throw new ApplicationSpecificException("some good message", ase);
    }
}