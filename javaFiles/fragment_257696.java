GeneratePresignedUrlRequest generatePresignedUrlRequest = 
                new GeneratePresignedUrlRequest(bucketName, objectKey);
generatePresignedUrlRequest.setMethod(HttpMethod.GET); 
generatePresignedUrlRequest.setExpiration(expiration);

URL url = s3client.generatePresignedUrl(generatePresignedUrlRequest); 
String urlString = url.toString();

Runtime run  = Runtime.getRuntime();
Process proc = run.exec("ffmpeg -i " + urlString +" -ss 00:00:00.500 -vframes 1 thumbnail.png");