@Service
public class MyService {
    private final AmazonS3Client s3Client; //Just fine

    @Autowired
    public MyService(AmazonS3Client amazonS3Client) { // Must match the bean name
        this.s3Client = amazonS3Client;
    }

    ...
}