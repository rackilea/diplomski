[root@dub-vcd-vms165 ~]# impala-shell
Starting Impala Shell without Kerberos authentication
Connected to XXXXXX
Server version: impalad version cdh5-1.3.0 RELEASE (build 40e1b62cf0b97f666d084d9509bf9639c575068c)
Welcome to the Impala shell. Press TAB twice to see a list of available commands.

Copyright (c) 2012 Cloudera, Inc. All rights reserved.

(Shell build version: Impala Shell vcdh5-1.3.0 (40e1b62) built on Tue Mar 25 13:46:44 PDT 2014)
[XXXXXX:21000] > select * from foo;
Query: select * from foo
+----+-----------+
| id | msg       |
+----+-----------+
| 1  | message 1 |
+----+-----------+
Returned 3 row(s) in 0.62s
[XXXXXX:21000] >