@GetMapping(value = "/downloadfile/**", produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
    public ResponseEntity<S3ObjectInputStream> downloadFile(HttpServletRequest request) {
       //reads the content from S3 bucket and returns a S3ObjectInputStream
       S3Object object = publishAmazonS3.getObject("12345bucket", "/logs/file1.log");
       S3ObjectInputStream finalObject = object.getObjectContent();

        final StreamingResponseBody body = outputStream -> {
            int numberOfBytesToWrite = 0;
            byte[] data = new byte[1024];
            while ((numberOfBytesToWrite = finalObject.read(data, 0, data.length)) != -1) {
                System.out.println("Writing some bytes..");
                outputStream.write(data, 0, numberOfBytesToWrite);
            }
            finalObject.close();
        };
        return new ResponseEntity<>(body, HttpStatus.OK);
    }