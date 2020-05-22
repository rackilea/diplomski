byte[] bI = org.apache.commons.codec.binary.Base64.decodeBase64((base64Data.substring(base64Data.indexOf(",")+1)).getBytes());

InputStream fis = new ByteArrayInputStream(bI);

AmazonS3 s3 = new AmazonS3Client();
Region usWest02 = Region.getRegion(Regions.US_WEST_2);
s3.setRegion(usWest02);
ObjectMetadata metadata = new ObjectMetadata();
metadata.setContentLength(bI.length);
metadata.setContentType("image/png");
metadata.setCacheControl("public, max-age=31536000");
s3.putObject(BUCKET_NAME, filename, fis, metadata);
s3.setObjectAcl(BUCKET_NAME, filename, CannedAccessControlList.PublicRead);