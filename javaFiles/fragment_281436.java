public class Grep extends DirectoryWalker
{
    public Grep(){
        super();
    }

    public List clean(File startDirectory){
      List results = new ArrayList();
      walk(startDirectory, results);
      return results;
    }

    protected boolean handleDirectory(File directory,
                                      int depth, Collection results){
      // Decide if a (sub) directory will be handled for recursive search
      return true;
    }

    protected void handleFile(File file, int depth, Collection results)
    {
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");
        try{
            while (it.hasNext()){
                String line = it.nextLine();
                if(line.matches("myRegEx")){
                    results.add(file);
                }
            }
         }
         finally {LineIterator.closeQuietly(it);}
    }
}