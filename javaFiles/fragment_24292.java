// get the shape file from S3 to local filesystem
File localshp = new File("/tmp/download.shp");
s3.getObject(new GetObjectRequest(bucket, key), localshp);

// now store file:// URL in the map
map.put("url", localshp.getURI().getURL().toString());