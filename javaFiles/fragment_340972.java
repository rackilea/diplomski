import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import org.apache.parquet.avro.AvroParquetReader;
import org.apache.parquet.hadoop.ParquetReader;
import org.apache.hadoop.fs.Path;
import org.apache.avro.generic.GenericRecord;
import org.apache.hadoop.conf.Configuration;

...

final String path = "s3a://"+bucketName+"/"+pathName;
final Configuration configuration = new Configuration();
configuration.setClass("fs.s3a.aws.credentials.provider", ProfileCredentialsProvider.class,
        AWSCredentialsProvider.class);
ParquetReader<GenericRecord> parquetReader =
        AvroParquetReader.<GenericRecord>builder(new Path(path)).withConf(configuration).build();