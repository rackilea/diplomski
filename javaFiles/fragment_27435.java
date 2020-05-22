File f = new File("C:\\");  // what ever directory you want. 

FilenameFilter totoFilter = new FilenameFilter()
{
    public boolean accept(File dir, String name) 
    {
        String lowercaseName = name.toLowerCase();
        if (lowercaseName.endsWith("TOTO.xml")) return true;
        else                                    return false;

    }
};

FilenameFilter tataFilter = new FilenameFilter() {
    public boolean accept(File dir, String name) {
        String lowercaseName = name.toLowerCase();
        if (lowercaseName.endsWith("TOTO.xml")) return true;
        else                                    return false;
    };

    String[] tataFiles = f.list(tataFilter);
    Arrays.sort(tataFiles, Collections.reverseOrder());

    String[] totoFiles = f.list(totoFilter);
    Arrays.sort(totoFiles, Collections.reverseOrder());

    System.out.println(tataFiles[0]);
    System.out.println(totoFiles[0]);
}