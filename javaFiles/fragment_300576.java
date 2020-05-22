CREATE TABLE rating_regex(
  userId string,
  movieId string,
  rating string,
  time string) 
ROW FORMAT SERDE 'org.apache.hadoop.hive.contrib.serde2.RegexSerDe' 
WITH serdeproperties("input.regex" = "(.+)::(.+)::(.+)::(.+)",
"output.format.string" = "%1$s %2$s %3$s %4$s")
STORED AS TEXTFILE;