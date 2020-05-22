AmazonCloudFront cloudFront = AmazonCloudFrontAsyncClientBuilder.standard()
    .withRegion(Regions.AP_EAST_1)
    .withCredentials(new AWSStaticCredentialsProvider(
        new BasicAWSCredentials(route53Manager.getAccessKey(), route53Manager.getSecretKey())))
    .build();

//create the request
GetDistributionConfigRequest distributionConfigRequest = new GetDistributionConfigRequest("E1EJBNNYJZ6G34");

//submit the request and get the resulting config
GetDistributionConfigResult distributionConfigResult = cloudFront.getDistributionConfig(distributionConfigRequest);

Aliases aliases = new Aliases()
    .withItems(subDomain)
    .withQuantity(1);

DistributionConfig config = distributionConfigResult.getDistributionConfig()
    .withEnabled(true)
    .withAliases(aliases);

//create the update request
UpdateDistributionRequest updateDistributionRequest = new UpdateDistributionRequest(config, distributionConfigRequest.getId(), distributionConfigResult.getETag());

//submit the request to update the config
UpdateDistributionResult updateDistributionResult = cloudfront.updateDistribution(updateDistributionRequest);

//print output of result to console
System.out.println(updateDistributionResult);