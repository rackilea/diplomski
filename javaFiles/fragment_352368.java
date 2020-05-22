@Override
protected void setup(Context context) throws IOException,
                    InterruptedException {

            Path[] uris = DistributedCache.getLocalCacheFiles(context
                    .getConfiguration());

            String patternsFile = uris[0].toString();


            BufferedReader in = new BufferedReader(new FileReader(patternsFile));
           ...

            in.close();



        }