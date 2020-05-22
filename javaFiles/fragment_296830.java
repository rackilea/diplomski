-- -- To dump sql data to csv file
SELECT * 
FROM test.yourTableName
INTO OUTFILE 'C:/test/yourTableName.csv'
FIELDS ENCLOSED BY '"' TERMINATED BY ';' ESCAPED BY '"'
LINES TERMINATED BY '\r\n';


-- -- To load data to sql database from csv
LOAD DATA INFILE 'C:/test/yourTableName.csv' INTO TABLE test.yourTableName
 FIELDS ENCLOSED BY '"' TERMINATED BY ';' ESCAPED BY '"'
LINES TERMINATED BY '\r\n';