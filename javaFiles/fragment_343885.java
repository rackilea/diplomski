import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.{S3ObjectSummary, ObjectListing, GetObjectRequest}
import scala.collection.JavaConversions.{collectionAsScalaIterable => asScala}

def map[T](s3: AmazonS3Client, bucket: String, prefix: String)(f: (S3ObjectSummary) => T) = {

  def scan(acc:List[T], listing:ObjectListing): List[T] = {
    val summaries = asScala[S3ObjectSummary](listing.getObjectSummaries())
    val mapped = (for (summary <- summaries) yield f(summary)).toList

    if (!listing.isTruncated) mapped.toList
    else scan(acc ::: mapped, s3.listNextBatchOfObjects(listing))
  }

  scan(List(), s3.listObjects(bucket, prefix))
}