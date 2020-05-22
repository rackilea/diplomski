SQLContext sqlcontext=new SQLContext(context);
DataFrame outDataFrame=sqlcontext.createDataFrame(finalOutPutRDD, WebHttpOutPutVO.class);
Properties prop = new java.util.Properties();
prop.setProperty("database", "Web_Session");
prop.setProperty("user", "user");
prop.setProperty("password", "pwd@123");
prop.setProperty("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
outDataFrame.write().mode(org.apache.spark.sql.SaveMode.Append).jdbc("jdbc:sqlserver://<Host>:1433", "test_table", prop);