S3Object s3Object = s3Client.getObject(bucket, key);
S3ObjectInputStream s3Stream = s3Object.getObjectContent();

ObjectMapper objectMapper = new ObjectMapper();
JsonFactory jsonFactory = objectMapper.getFactory();
JsonParser jsonParser = jsonFactory.createParser(s3Stream);

JsonParser.nextToken()...etc