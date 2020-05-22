mysql> create table tbl_mq( i int not null auto_increment, name varchar(10), primary key (i) );
Query OK, 0 rows affected (0.16 sec)

mysql> delimiter //
mysql> create procedure multi_query()
    -> begin
    ->  select count(*) as name_count from tbl_mq;
    ->  insert into tbl_mq( names ) values ( 'ravi' );
    ->  select last_insert_id();
    ->  select * from tbl_mq;
    -> end;
    -> //
Query OK, 0 rows affected (0.02 sec)
mysql> delimiter ;
mysql> call multi_query();
+------------+
| name_count |
+------------+
|          0 |
+------------+
1 row in set (0.00 sec)

+------------------+
| last_insert_id() |
+------------------+
|                3 |
+------------------+
1 row in set (0.00 sec)

+---+------+
| i | name |
+---+------+
| 1 | ravi |
+---+------+
1 row in set (0.00 sec)

Query OK, 0 rows affected (0.00 sec)