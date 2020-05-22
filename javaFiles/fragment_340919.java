KmsClient kmsClient = KmsClient.builder().build();
DescribeKeyRequest req = DescribeKeyRequest.builder().keyId("alias/your_kms_alias").build();
DescribeKeyResponse res = kmsClient.describeKey(req);

// See https://docs.aws.amazon.com/kms/latest/APIReference/API_DescribeKey.html
// For the response you will get back from DescribeKey

// Then create the request to S3

PutObjectRequest putObjectRequest =
    PutObjectRequest.builder()
        .bucket(bucket)
        .key(key)
        .serverSideEncryption(ServerSideEncryption.AWS_KMS)
        .ssekmsKeyId(res.keyMetadata().keyId()) // the actual keyId from KMS CMK
        .build();

s3Client.putObject(putObjectRequest, RequestBody.fromString(data));