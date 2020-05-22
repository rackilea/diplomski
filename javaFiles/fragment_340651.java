mysql> select user,host,password from mysql.user where user like '%joe%';
+--------+------+-------------------------------------------+
| user   | host | password                                  |
+--------+------+-------------------------------------------+
| joe7   | %    | *7F748B224136BAF824D3FF63F0C5B18BB93CFA8B |
| joe8   | %    | *6C8989366EAF75BB670AD8EA7A7FC1176A95CEF4 |
| joe123 | %    | *0913BF2E2CE20CE21BFB1961AF124D4920458E5F |
+--------+------+-------------------------------------------+