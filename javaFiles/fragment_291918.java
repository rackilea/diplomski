create table test 
  (type int, SCHEMA_ID int, RECORD_NAME text, 
  SCHEMA_VALUE text, TIMESTAMP timeuuid, 
  primary key (type, timestamp));

select * from test where type IN (0,1,2,3) and timestamp < 58e0a7d7-eebc-11d8-9669-0800200c9a66;