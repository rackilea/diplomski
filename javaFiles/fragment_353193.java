import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.QueryJobConfiguration;

public class QuickstartSample {
  public static void main(String... args) throws Exception {
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    String query = "Your-Query";
    //setUseLegacySql(true) below
    QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).setUseLegacySql(true).build();
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
        for (FieldValue val : row) {
             System.out.printf("%s,", val.toString());
        }
        System.out.printf("\n");
    }
  }
}