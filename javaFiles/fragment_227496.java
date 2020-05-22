val df = sc.parallelize(Array( (1, "test"), (2, "mytest") )).toDF("A", "B")
df.show()

+---+------+
|  A|     B|
+---+------+
|  1|  test|
|  2|mytest|
+---+------+

df.toJSON.collect.mkString("[", "," , "]" )
String = [{"A":1,"B":"test"},{"A":2,"B":"mytest"}]