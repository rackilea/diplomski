private static void setJobConf(Object theObject, Configuration conf) {
75     //If JobConf and JobConfigurable are in classpath, AND
76     //theObject is of type JobConfigurable AND
77     //conf is of type JobConf then
78     //invoke configure on theObject
79     try {
80       Class<?> jobConfClass = 
81         conf.getClassByName("org.apache.hadoop.mapred.JobConf");
82       Class<?> jobConfigurableClass = 
83         conf.getClassByName("org.apache.hadoop.mapred.JobConfigurable");
84        if (jobConfClass.isAssignableFrom(conf.getClass()) &&
85             jobConfigurableClass.isAssignableFrom(theObject.getClass())) {
86         Method configureMethod = 
87           jobConfigurableClass.getMethod("configure", jobConfClass);
88         configureMethod.invoke(theObject, conf);
89       }
90     } catch (ClassNotFoundException e) {
91       //JobConf/JobConfigurable not in classpath. no need to configure
92     } catch (Exception e) {
93       throw new RuntimeException("Error in configuring object", e);
94     }
95   }