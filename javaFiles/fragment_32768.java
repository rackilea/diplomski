String region = "us-east-1";
String service = "es";
String url = "???"; // put the AWS ElasticSearch endpoint here

DefaultAWSCredentialsProviderChain awsCredentialsProvider = new DefaultAWSCredentialsProviderChain();
final AWSSigner awsSigner = new AWSSigner(awsCredentialsProvider, region, service, () -> new LocalDateTime(DateTimeZone.UTC));

JestClientFactory factory = new JestClientFactory() {
    @Override
    protected HttpClientBuilder configureHttpClient(HttpClientBuilder builder) {
        builder.addInterceptorLast(new AWSSigningRequestInterceptor(awsSigner));
        return builder;
    }
};
factory.setHttpClientConfig(new HttpClientConfig.Builder(url)
        .multiThreaded(true)
        .build());
JestClient client = factory.getObject();