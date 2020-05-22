// Create a spark session
SparkSession session = SparkSession.builder().appName("name here").getOrCreate();

// Create datasets for both input
Dataset<Fishnet> fishnet = session.read().format("csv").option("header", true).option("inferSchema", true).load("fishnet.csv").as(Encoders.bean(Fishnet.class));
Dataset<GeoObject> geoObject = session.read().format("csv").option("header", true).option("inferSchema", true).load("geoObject.csv").as(Encoders.bean(GeoObject.class));

// Create temp view on datasets
fishnet.createOrReplaceTempView("fishnet");
geoObject.createOrReplaceTempView("geoObject");

// Now create a query to retrieve the result [objid lat lon cell_id]
Dataset<Row> result = session.sql("select objid, lat, lon, cell_id from fishnet, geoObject where lat >= minlat and lat <= maxlat and lon >= minlon and lon <= maxlon");