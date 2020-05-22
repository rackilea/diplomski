// ...
 ObjectMetadata omd = new ObjectMetadata();
 // a tiny code line, but with a "huge" information gain and memory saving!;)
 omd.setContentLength(file.length());

 s3Client.putObject(new PutObjectRequest(ABuck, AFkey, file.getInputStream(), omd).withCannedAcl(CannedAccessControlList.PublicRead));
 // ...