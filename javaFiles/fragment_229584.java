db2inst1@blusrv:~> db2 "create type INTARRAY AS INTEGER ARRAY[]"
DB20000I  The SQL command completed successfully.
db2inst1@blusrv:~> db2 "create or replace procedure testarray(in checkstatus integer, in jobid intarray) begin call dbms_output.put_line('testarray'); end"
DB20000I  The SQL command completed successfully.
db2inst1@blusrv:~> db2 set serveroutput on
DB20000I  The SET SERVEROUTPUT command completed successfully.
db2inst1@blusrv:~> db2 "begin declare v intarray; set v =  array[21,22,23]; call testarray(1,v); end"
DB20000I  The SQL command completed successfully.

testarray