public class ReadCSV {

    private static final SparkSession spark = new SparkSession
            .Builder()
            .master("local[*]")
            .getOrCreate();

    public static void main(String[] args) {

        spark.sparkContext().setLogLevel("ERROR");

        Dataset<EventCSVRow> eventCSVRowDataset = getEventCSVRow(".\\eventLog\\*.csv"); //events from the CSVs

        Dataset<FeederFileRow> feederFileRowDataset = getFeederFileDataset(".\\feeder\\*.DAT"); // all rows from all .DATs

        Dataset<Andamyo> joined = eventCSVRowDataset
            .crossJoin(feederFileRowDataset).as(Encoders.bean(Andamyo.class))
            .filter(andamyo -> {
                final long eventEpoch = Long.parseLong(andamyo.getEventEpoch());
                final long maxEpoch = Long.parseLong(andamyo.getFeederEpoch()) + andamyo.getLineCount();
                return Long.parseLong(andamyo.getFeederEpoch()) <= eventEpoch && eventEpoch <= maxEpoch;
            });

    }
}