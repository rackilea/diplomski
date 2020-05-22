String confArchive = "spark.yarn.cache.confArchive="+hdfs+"/user/"+userName+"/.sparkStaging/"+applicationId+"/__spark_conf__.zip";
    String filenames = "spark.yarn.cache.filenames=";
    String sizes = "spark.yarn.cache.sizes=";
    String timestamps = "spark.yarn.cache.timestamps=";
    String types = "spark.yarn.cache.types=";
    String visibilities = "spark.yarn.cache.visibilities=";
    for (Map<String,String> localResource:localResources) {
        filenames+=localResource.get("resource")+"#"+localResource.get("key")+",";
        sizes+=localResource.get("size")+",";
        timestamps+=localResource.get("timestamp")+",";
        types+=localResource.get("type")+",";
        visibilities+=localResource.get("visibility")+",";

    }
    properties+=confArchive+"\n";
    properties+=filenames.substring(0,filenames.length()-1)+"\n";
    properties+=sizes.substring(0,sizes.length()-1)+"\n";
    properties+=timestamps.substring(0,timestamps.length()-1)+"\n";
    properties+=types.substring(0,types.length()-1)+"\n";
    properties+=visibilities.substring(0,visibilities.length()-1)+"\n";