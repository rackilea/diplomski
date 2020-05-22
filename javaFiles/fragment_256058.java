ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
     .withBucketName(bucketName);
 ObjectListing objectListing;
 do {
     objectListing = s3.listObjects(listObjectsRequest);
     System.out.println("Enter the path where to save yout file");
     Scanner scan = new Scanner(System.in);
     String path = scan.nextLine();
     fileOne = new File(path);
     fw = new FileWriter(fileOne.getAbsoluteFile(), true);
     bw = new BufferedWriter(fw);
     bw.write("Writing data to file");
     bw.write("\n");
     for (S3ObjectSummary objectSummary: objectListing.getObjectSummaries()) {
         String key = objectSummary.getKey();
         String dummyKey = key.substring(2);
         if (dummyKey.equalsIgnoreCase("somestring")) {
             S3Object s3object = s3.getObject(new GetObjectRequest(bucketName, key));
             BufferedReader reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent()));
             String line;
             int i = 0;
             while ((line = reader.readLine()) != null) {
                 if (i > 0) {
                     bw.append(line + "," + s3object.getKey().substring(0, 2));
                     bw.append(objectSummary.getLastModified().toString());
                     bw.newLine();
                 }
                 i++;
                 System.out.println(line);
             }
         }
         //                    bw.close();
     }
     listObjectsRequest.setMarker(objectListing.getNextMarker());
 } while (objectListing.isTruncated());