try
{
       if (args.length != 0)
       {
           datasetFile = args[0];
           in = new BufferedReader(new FileReader(datasetFile));
       }
}
catch(FileNotFoundException e)
{
    e.printStackTrace();
}