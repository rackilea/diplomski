AWSCredentials longTermCredentials_ =  ...
STSAssumeRoleSessionCredentialsProvider roleCredsProvider = 
    new STSAssumeRoleSessionCredentialsProvider(
        longTermCredentials_, 
        "my_lambda", 
        "BucketListSession");
AmazonS3Client s3Client = new AmazonS3Client(roleCredsProvider);