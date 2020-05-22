c:\db-derby-10.8.2.2\bin>ij
ij version 10.8
ij> connect 'jdbc:derby:c:/temp/sotest';
ij> create table foo (datetime timestamp);
0 rows inserted/updated/deleted
ij> insert into foo values (current_timestamp);
1 row inserted/updated/deleted
ij> commit;
ij> select *
from foo
where datetime > {fn timestampadd(SQL_TSI_DAY, -10, current_timestamp)};
> > DATETIME
-----------------------------
2012-06-10 12:32:48.859

1 row selected
ij>