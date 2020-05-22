private void generateSparkConfInHdfs(String applicationId, String userName, String sparkConfProperties, String sparkHadoopConf) throws IOException {
    String path = hdfs+"/user/"+userName+"/.sparkStaging/"+applicationId+"/__spark_conf__.zip";
    Path hdfsPath = new Path(path);
    ZipOutputStream os = new ZipOutputStream(getHdfs().create(hdfsPath));
    os.putNextEntry(new ZipEntry("__hadoop_conf__/"));
    os.putNextEntry(new ZipEntry("__spark_conf__.properties"));
    os.write(sparkConfProperties.getBytes(),0,sparkConfProperties.getBytes().length);
    os.putNextEntry(new ZipEntry("__spark_hadoop_conf__.xml"));
    os.write(sparkHadoopConf.getBytes(),0,sparkHadoopConf.getBytes().length);
    os.close();
}