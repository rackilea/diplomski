import com.couchbase.client.java.Bucket;

public class MyCouchBaseRepository{

private Bucket bucket;

public MyCouchBaseRepository(<My Repository that extends CouchbasePagingAndSortingRepository>  myRepository){
    bucket = myRepository.getCouchbaseOperations().getCouchbaseBucket();
     createIndices();
}


private void createIndices(){

   bucket.bucketManager().createN1qlPrimaryIndex(true, false)

   bucket.query(N1qlQuery.simple("CREATE INDEX xyz ON `myBucket`(userId) WHERE _class = 'com.example.User'"))
   ...       

}

}