fc.setFileSystemView(new FileSystemView(){
    // this method is abstract but since you don't
    // want to create directories here you don't 
    // need to implement it.
    @Override
    public File createNewFolder(File f) throws IOException {
        return null;
    }

    // manipulate the default getFiles method that creates
    // the list of files in the current directory
    @Override
    public File[] getFiles(File dir, boolean useFileHiding){
        // get the list of files from default implementation
        File[] files = super.getFiles(dir,useFileHiding);
        // get the parent directory of current
        File parent = getParentDirectory(dir);
        // skip the next for problematic folders with
        // empty names and root folders
        if(!dir.getName().isEmpty() && !isRoot(dir)){
            // create a new list of files with one extra place
            File[] nfiles = new File[files.length + 1];
            // add a special file to list that points to parent directory
            nfiles[0] = new File(parent.getAbsolutePath()){
                // set a special name for that file
                @Override
                    public String getName(){return "...";}
                };
            // add the rest of files to list
            for(int i = 0; i < files.length; i++)
                nfiles[i+1] = files[i];
            // use the new list
            files = nfiles; 
        }
        // return list of files
        return files;
    }

    // some special folders like "c:" gets converted
    // in shellfolders.Then our setted name "..." would
    // get converted to "local drive (c:)". This garantees
    // that our setted name will be used.
    @Override
    public String getSystemDisplayName(File f) {
        return f.getName();
    }   
});