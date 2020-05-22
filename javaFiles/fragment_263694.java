import org.apache.spark.sql.Dataset
import org.apache.spark.sql.functions._

case class UserAndRequest(
                           USER_NAME:String,
                           REQUEST_DATE:java.sql.Date,
                           START_DATE:java.sql.Date,
                           END_DATE:java.sql.Date,
                           STATUS:String,
                           REQUEST_ID:Long
                         )

val joined : Dataset[UserAndRequest] = df1.withColumn("REQUEST_ID", monotonically_increasing_id).
  join(df2,$"USER_NAME" === $"NAME", "left").
  as[UserAndRequest]

val lastRowByRequestId = joined.
  groupByKey(_.REQUEST_ID).
  reduceGroups( (x,y) =>
    if (x.REQUEST_DATE.getTime > x.END_DATE.getTime && x.END_DATE.getTime > y.END_DATE.getTime) x else y
  ).map(_._2)

def logic(status: String): String = {
  if (status == "IN") "Our user"
  else if (status == "OUT") "not our user"
  else "No Information"
}

val logicUDF = udf(logic _)

val finalDF = lastRowByRequestId.withColumn("USER_STATUS",logicUDF($"REQUEST_DATE"))