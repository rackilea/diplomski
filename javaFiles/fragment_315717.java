imageUpload.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            FileChooser  fileChooser=new FileChooser();
            fileChooser.setInitialDirectory(new File("c:\\"));
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG Images","*.jpg"),
                    new FileChooser.ExtensionFilter("JPEG Images","*.jpeg"),
                    new FileChooser.ExtensionFilter("PNG Images","*.png"));

            List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);
            if (selectedFiles != null) {
                for (File file : selectedFiles) {
                    try {

                        AWSCredentials Credentials = new BasicAWSCredentials(
                                "AWSAccessKeyId",
                                "AWSSecretKey");

                        AmazonS3Client amazonS3Client = new AmazonS3Client(Credentials);
                        String bucketName = "awsimagetrading";
                        String key = file.getName();
                        System.out.println("Uploading a new object to S3 from a file\n");
                        AmazonS3 s3client = new AmazonS3Client(Credentials);
                        s3client.putObject(new PutObjectRequest(bucketName,key,file));
                        URL url = amazonS3Client.generatePresignedUrl(bucketName,key,Date.from(Instant.now().plus(5,ChronoUnit.MINUTES)));
                        System.out.println(url);
                        //label.setText(url.toString());

                    } catch (AmazonClientException e) {
                        e.printStackTrace();
                    }
                }
        }
    });