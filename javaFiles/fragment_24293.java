// get current time and add one hour
java.util.Date expiration = new java.util.Date();
long msec = expiration.getTime();
msec += 1000 * 60 * 60;
expiration.setTime(msec);

// request pre-signed URL that will allow bearer to GET the object
GeneratePresignedUrlRequest gpur = new GeneratePresignedUrlRequest(bucket, key);
gpur.setMethod(HttpMethod.GET);
gpur.setExpiration(expiration);

// get URL that will expire in one hour
URL url = s3.generatePresignedUrl(gpur);