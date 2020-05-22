//files = new PatternDirWalker( filesPattern ).list( baseDir );
files = new DirScanner( filesPattern ).list( baseDir );


public class DirScanner {

    private String pattern;

    public DirScanner( String pattern ) {
        this.pattern = pattern;
    }

    public List<File> list( File dirToScan ) throws IOException {

            DirectoryScanner ds = new DirectoryScanner();
            String[] includes = {  this.pattern };
            //String[] excludes = {"modules\\*\\**"};
            ds.setIncludes(includes);
            //ds.setExcludes(excludes);
            ds.setBasedir( dirToScan );
            //ds.setCaseSensitive(true);
            ds.scan();

            String[] matches = ds.getIncludedFiles();
            List<File> files = new ArrayList(matches.length);
            for (int i = 0; i < matches.length; i++) {
                files.add( new File(matches[i]) );
            }
            return files;
    }

}// class