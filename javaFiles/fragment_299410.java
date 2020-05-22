JavaRDD<MeasuredValue> rdd = javaFunctions(sc).cassandraTable("SB1000_47130646", "Measured_Value", mapRowTo(MeasuredValue.class));
JavaRDD<Value> valueRdd = rdd.flatMap(new FlatMapFunction<MeasuredValue, Value>(){
@Override 
public Iterable<Value> call(MeasuredValue row) throws Exception { 
double start_frequency = row.getStart_frequency(); 
float power = row.getPower(); 
double bandwidth = row.getBandwidth(); 

// Define Variable 
double channel,channel_end, increment;  

// Initialize Variables 
channel_end = 1.6159E8; 
increment = 5000; 

List<Value> list = new ArrayList<Value>(); 
// Create Channel Power Buckets 
for(channel = 1.6000E8; channel <= channel_end; ){ 
if( (channel >= start_frequency) && (channel <= (start_frequency + bandwidth)) ) { 
list.add(new Value(channel, power)); 
} // end if 
channel+=increment; 
} // end for 

return list; 
}    
    });

    sqlContext.createDataFrame(valueRdd, Value.class).groupBy(col("channel"))
    .agg(min("power"), max("power"), avg("power"))
    .write().mode(SaveMode.Append)      
    .option("table", "results")
    .option("keyspace", "model")
    .format("org.apache.spark.sql.cassandra").save();

} // end session

public static class MeasuredValue implements Serializable {

        public MeasuredValue() { }

        private double start_frequency;
        public double getStart_frequency() { return start_frequency; }
        public void setStart_frequency(double start_frequency) { this.start_frequency = start_frequency; }

        private double bandwidth ;
        public double getBandwidth() { return bandwidth; }
        public void setBandwidth(double bandwidth) { this.bandwidth = bandwidth; }

        private float power;    
        public float getPower() { return power; }
        public void setPower(float power) { this.power = power; }

    }