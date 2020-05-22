import org.apache.spark.sql.functions.udf

Dataset<Row> inventory = spark.read().option("multiLine", true).option("mode", "PERMISSIVE")
                    .json("path to json inventory");
Dataset<Row> alerts = spark.read().option("multiLine", true).option("mode", "PERMISSIVE")
                           .json("path to alerts json")
                           .select($"partyId", struct("columns").as("ALERTS"));
//column names are all the columns that you want in nested fiels with comma separated

Dataset<Row> inventoryAlerts = inventory.join(alerts);
        inventoryAlerts.printSchema();