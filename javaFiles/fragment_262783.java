mysql> select now();
+---------------------+
| now()               |
+---------------------+
| 2015-05-10 23:46:44 |
+---------------------+
1 row in set (0.00 sec)

mysql> select curtime();
+-----------+
| curtime() |
+-----------+
| 23:46:53  |
+-----------+
1 row in set (0.00 sec)


where arrivaltime = curtime()