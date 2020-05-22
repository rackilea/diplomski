//---------------------------------------------------------------------     
    // Amazon S3
    //---------------------------------------------------------------------     
        class S3 extends AmazonS3Client
         {final String bucket;
          S3(String u, String p, String Bucket)
           {super(new BasicAWSCredentials(u, p));
            bucket = Bucket;
           }
          boolean put(String k, String v)      
           {try 
             {final ByteArrayInputStream b = new ByteArrayInputStream(v.toString().getBytes());
              putObject(bucket, k, b, new ObjectMetadata());
              setObjectAcl(bucket, k, CannedAccessControlList.PublicRead);  // Has to be here to allow change to reduced redundancy
              changeObjectStorageClass(bucket, k, StorageClass.ReducedRedundancy);
              setObjectAcl(bucket, k, CannedAccessControlList.PublicRead);  // Has to be repeated because it is now a new object again
              return true; 
             }
            catch(Exception e) {log("Cannot put "+bucket+"/"+k+" to S3 because "+e);}
            return false; 
           }
          String get(String k) 
           {try 
             {final S3Object f = getObject(bucket, k);
              final BufferedInputStream i = new BufferedInputStream(f.getObjectContent());  
              final StringBuilder s = new StringBuilder(); 
              final byte[]b = new byte[1024];
              for(int n = i.read(b); n != -1; n = i.read(b)) {s.append(new String(b, 0, n));}
              return s.toString(); 
             }
            catch(Exception e) {log("Cannot get "+bucket+"/"+k+" from S3 because "+e);}
            return null; 
           }
          String[]list(String d) 
           {try 
             {final ObjectListing l = listObjects(bucket, d);
              final List<S3ObjectSummary> L = l.getObjectSummaries(); 
              final int n = L.size();
              final String[]s = new String[n];  
              for(int i = 0; i < n; ++i)
               {final S3ObjectSummary k = L.get(i);
                s[i] = k.getKey();
               } 
              return s; 
             }
            catch(Exception e) {log("Cannot list "+bucket+"/"+d+" on S3 because "+e);}
            return new String[]{}; 
           }
         }
       }