import com.amazonaws.services.cloudfront;
import com.amazonaws.services.cloudfront.model.CreateInvalidationRequest;
import com.amazonaws.services.cloudfront.model.Paths;
import com.amazonaws.services.cloudfront.model.InvalidationBatch;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

AWSCredentials awsCredentials = new DefaultAWSCredentialsProviderChain().getCredentials();
AmazonCloudFrontClient client = new AmazonCloudFrontClient(awsCredentials);

Paths invalidation_paths = new Paths().withItems("/path/to/invalidate/foo.jpg", "/path/file2.txt").withQuantity(2);
InvalidationBatch invalidation_batch = new InvalidationBatch(invalidation_paths, "unique_id_like_a_date");
CreateInvalidationRequest invalidation = new CreateInvalidationRequest("distributionID", invalidation_batch);
CreateInvalidationResult ret = client.createInvalidation(invalidation);