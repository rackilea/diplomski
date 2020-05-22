public static void main(String a[]) {
     UserGroupInformation ugi
     = UserGroupInformation.createRemoteUser("root");

     try {


        ugi.doAs(new PrivilegedExceptionAction<Void>() {

            public Void run() throws Exception {

                conf = new Configuration();
                    //fs.default.name should match the corresponding value 
                    // in your core-site.xml in hadoop cluster
                conf.set("fs.default.name","hdfs://hostname:9000");
                conf.set("hadoop.job.ugi", "root");
                    // in case you are running mapreduce job , need to set
                    // 'mapred.job.tracker' as you did
                    conf.set("mapred.job.tracker", "hostname:port"); 

                 // do your code here. 

                return null;
            }
        });

    } catch (Exception e) {
        e.printStackTrace();
    }

}