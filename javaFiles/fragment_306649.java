@Autowired
private Storage gcs;

public void upload(String report) {

    gcs.create(BlobInfo
                    .newBuilder("bucket_name", "fileName.json")
                    .build(),
            report.getBytes());

}