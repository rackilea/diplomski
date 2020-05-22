> [testuser02@Abcd-Host1 ~]$ beeline

> beeline> !connect jdbc:hive2://Abcd-Host1:10000/default "" "" ""
> 
> 0: jdbc:hive2://Abcd-Host1:10000/default> show tables;

+------------+
|  tab_name  |
+------------+
| sample_07  |
| sample_08  |
| test1      |
+------------+
3 rows selected (0.334 seconds)