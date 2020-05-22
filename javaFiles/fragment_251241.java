cqlsh> create keyspace test with replication = {'class': 'SimpleStrategy', 'replication_factor':2};
cqlsh> create table test.keys (key int primary key, val int);
cqlsh> insert into test.keys (key, val) values (1, 1);
cqlsh> select * from test.keys;

 key | val
-----+-----
   1 |   1