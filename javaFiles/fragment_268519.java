import java.sql.Timestamp;
import java.text.SimpleDateFormat;

SimpleDateFormat dateFormat = new SimpleDateFormat("....Date time pattern...");
spark.udf().register("timestamp", new UDF1<String, Timestamp>() {
    private static final long serialVersionUID = 1335972766810808134L;
    @Override
    public Timestamp call(String source)
    {
      try{
            return new Timestamp(dateFormat.parse(source).getTime());
         } catch (ParseException e) {
                 e.printStackTrace();
         }
      }
      return null;
     }
 }, DataTypes.TimestampType);