CREATE EXTERNAL TABLE country
(
id int, 
country string
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
LOCATION 'hdfs:///example_hive/country';