BasicAWSCredentials credentials = new BasicAWSCredentials("ACCESS KEY", "SECRET KEY");
AmazonS3 service AmazonS3Client.builder()
             .withClientConfiguration(clientConfiguration)
             .withEndpointConfiguration(new EndpointConfiguration("YOUR_ENDPOINT", "YOUR_REGION"))
             .withCredentials(new AWSStaticCredentialsProvider(credentials))
             .build();