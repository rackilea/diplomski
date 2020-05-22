@GetMapping(value = "/findAllImages")
    public ResponseEntity<List<OutputStream>> findNamesOfAllImages() {

        List<String> names = new ArrayList<>();

        String password = ProcBuilder.run(
                "security",
                "-i", "find-generic-password",
                "-l", Parameters.getAppName(), "-w"
        );

        AWSCredentials credentials = new BasicAWSCredentials(
                Parameters.getAccessKey(),
                password
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();

        ObjectListing objectListing = s3client.listObjects(Parameters.getBucketName());

        for (S3ObjectSummary s3ObjectSummary : objectListing.getObjectSummaries()) {
            names.add(s3ObjectSummary.getKey());
        }

        List<OutputStream> outputStreams = new ArrayList<>();
        S3Object object = null;

        File file;
        int count = 0;

        for (String name : names) {

            object = s3client.getObject(new GetObjectRequest(Parameters.getBucketName(), name));;

            InputStream reader = new BufferedInputStream(object.getObjectContent());
            file = new File(name + (++count));

            OutputStream writer;

            try {

                writer = new BufferedOutputStream(new FileOutputStream(file));
                int read = -1;

                while (true) {

                    if (!((read = reader.read()) != -1))
                        break;

                    writer.write(read);
                    outputStreams.add(writer);
                }

                writer.flush();
                writer.close();
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(outputStreams);
    }