hive> SELECT collect_list(lower(val))
    > FROM (SELECT explode(array('AN', 'EXAMPLE', 'ARRAY')) AS val) t;
...
... Lots of MapReduce spam
...
MapReduce Total cumulative CPU time: 4 seconds 10 msec
Ended Job = job_1422453239049_0017
MapReduce Jobs Launched: 
Job 0: Map: 1  Reduce: 1   Cumulative CPU: 4.01 sec   HDFS Read: 283 HDFS Write: 17 SUCCESS
Total MapReduce CPU Time Spent: 4 seconds 10 msec
OK
["an","example","array"]
Time taken: 33.05 seconds, Fetched: 1 row(s)