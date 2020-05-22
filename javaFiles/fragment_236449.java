aws.s3.bucket.batch.bucket=com-kaizen-batch-dev
aws.s3.bucket.batch.root-folder=processed
aws.s3.bucket.batch.input-folder=input
aws.s3.bucket.batch.processed-folder=processed
aws.s3.bucket.batch.batch-job-folder=merchant-file


@Component
@ConfigurationProperties(prefix = "aws.s3.bucket.batch")
public class AWSProperties {
    private String bucket;
    private String rootFolder;
    private String inputFolder;
    private String processedFolder;
    private String region;

    // setter require
}