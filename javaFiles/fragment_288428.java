hive> DESCRIBE foo;
OK
id                          int                                 
data                        array<string>                       
Time taken: 0.774 seconds, Fetched: 2 row(s)
hive> SELECT * FROM foo;
OK
1001        ["ONE","TWO","THREE"]
1002        ["FOUR","FIVE","SIX","SEVEN"]
Time taken: 0.434 seconds, Fetched: 2 row(s)

hive> SELECT
    >   id, collect_list(lower(exploded))
    > FROM
    >   foo LATERAL VIEW explode(data) exploded_table AS exploded
    > GROUP BY id;
...
... Lots of MapReduce spam
...
MapReduce Total cumulative CPU time: 3 seconds 310 msec
Ended Job = job_1422453239049_0014
MapReduce Jobs Launched:
Job 0: Map: 1  Reduce: 1   Cumulative CPU: 3.31 sec   HDFS Read: 358 HDFS Write: 44 SUCCESS
Total MapReduce CPU Time Spent: 3 seconds 310 msec
OK
1001        ["one","two","three"]
1002        ["four","five","six","seven"]
Time taken: 34.268 seconds, Fetched: 2 row(s)