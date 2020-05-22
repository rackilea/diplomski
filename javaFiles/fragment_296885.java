AWSCredentialsProvider credentialsProvider = new AWSCredentialsProvider() {
    @Override
    public void refresh() {}
        @Override
        public AWSCredentials getCredentials() {
        return new AWSCredentials() {
            @Override
            public String getAWSSecretKey() {
                return "YOUR_SECRET_KEY";
            }
            @Override
            public String getAWSAccessKeyId() {
                return "YOUR_ACCESS_KEY";
            }
        };
    }
};

AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
            .withCredentials(credentialsProvider).build();