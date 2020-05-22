cqlsh> CONSISTENCY ALL;
Consistency level set to ALL.
cqlsh> insert into test.keys (key, val) values (2, 2);
Traceback (most recent call last):
  File "resources/cassandra/bin/cqlsh.py", line 1324, in perform_simple_statement
    result = future.result()
  File "resources/cassandra/bin/../lib/cassandra-driver.zip/cassandra-driver/cassandra/cluster.py", line 3133, in result
    raise self._final_exception
Unavailable: code=1000 [Unavailable exception] message="Cannot achieve consistency level ALL" info={'required_replicas': 2, 'alive_replicas': 1, 'consistency': 'ALL'}

cqlsh> select * from test.keys;
Traceback (most recent call last):
  File "resources/cassandra/bin/cqlsh.py", line 1324, in perform_simple_statement
    result = future.result()
  File "resources/cassandra/bin/../lib/cassandra-driver.zip/cassandra-driver/cassandra/cluster.py", line 3133, in result
    raise self._final_exception
Unavailable: code=1000 [Unavailable exception] message="Cannot achieve consistency level ALL" info={'required_replicas': 2, 'alive_replicas': 1, 'consistency': 'ALL'}