mysql> select * from test.nums;
+------+
| num  |
+------+
|    1 |
|    3 |
|    5 |
|    7 |
|    9 |
+------+
mysql> select * from test2.nums;
+------+
| num  |
+------+
|    2 |
|    4 |
|    6 |
|    8 |
+------+
mysql> select * from test.nums union select * from test2.nums order by num limit 3, 6;
+------+
| num  |
+------+
|    4 |
|    5 |
|    6 |
|    7 |
|    8 |
|    9 |
+------+