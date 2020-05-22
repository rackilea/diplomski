public void setup(Context context) throws IOException, InterruptedException {

Configuration conf = context.getConfiguration();
FileSystem fs = FileSystem.getLocal(conf);

Path[] dataFile = DistributedCache.getLocalCacheFiles(conf);
BufferedReader cacheReader = new BufferedReader(new InputStreamReader(fs.open(dataFile[0])));
// Implement here get_list method functionality

}