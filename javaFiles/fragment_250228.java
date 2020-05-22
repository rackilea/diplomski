public class App {

private static String PDF_PATH = "/tmp/pdf-test.pdf";

public static void main(String[] args) throws IOException {

    // prepare AWS credential
    BasicAWSCredentials awsCreds = new BasicAWSCredentials("xxx",
            "yyy");
    AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion("aaa")
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();

    // upload a test PDF
    File pdfFile = new File(PDF_PATH);
    PutObjectRequest request = new PutObjectRequest("aaa", "bbb", pdfFile );
    ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentType("application/pdf");
    metadata.setContentLength(pdfFile.length());
    request.setMetadata(metadata);
    s3Client.putObject(request);
}

}