@Override
public void setup(Context context)

{
  Configuration conf = context.getConfiguration();

try {

  cachefiles = DistributedCache.getLocalCacheFiles(conf);

  File database = new File(cachefiles[0].toString()); 

  reader = new DatabaseReader.Builder(database).build();

} catch (IOException e) {
  e.printStackTrace();
}

}