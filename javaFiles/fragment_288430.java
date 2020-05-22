hive> ADD JAR my_jar.jar;
Added my_jar.jar to class path
Added resource: my_jar.jar
hive> CREATE TEMPORARY FUNCTION lower_array AS 'my.package_name.LowerArray';
OK
Time taken: 2.803 seconds
hive> SELECT id, lower_array(data) FROM foo;
...
... Lots of MapReduce spam
...
MapReduce Total cumulative CPU time: 2 seconds 760 msec
Ended Job = job_1422453239049_0015
MapReduce Jobs Launched:
Job 0: Map: 1   Cumulative CPU: 2.76 sec   HDFS Read: 358 HDFS Write: 44 SUCCESS
Total MapReduce CPU Time Spent: 2 seconds 760 msec
OK  
1001        ["one","two","three"]
1002        ["four","five","six","seven"]
Time taken: 27.243 seconds, Fetched: 2 row(s)