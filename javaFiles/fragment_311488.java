public static List<File> listFiles(File rootDir, FileFilter filter, boolean recursive) {
    List<File> result = new ArrayList<File>();
    if( !rootDir.exists() || !rootDir.isDirectory() ) 
        return result;


    //Add all files that comply with the given filter
    File[] files = rootDir.listFiles(filter);
    for( File f : files) {
        if( !result.contains(f) )
            result.add(f);
    }

    //Recurse through all available dirs if we are scanning recursively
    if( recursive ) {
        File[] dirs = rootDir.listFiles(new DirFilter());
        for( File f : dirs ) {
            if( f.canRead() ) {
                result.addAll(listFiles(f, filter, recursive));
            }
        }
    }

    return result;
}