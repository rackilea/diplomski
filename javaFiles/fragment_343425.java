// for exlude file extension  
NotFileFilter suffixFileFilterFileFilter=new NotFileFilter(new 
SuffixFileFilter(new String[] { "txt", "java" }));  

//to include only selected extension use below one
//IOFileFilter suffixFileFilterFileFilter= new SuffixFileFilter(new String[] { "java", "txt" });

NotFileFilter directoryFileFilterFileFilter=new NotFileFilter(new 
PrefixFileFilter(new String[] { "tolearn", "dir2" }));   // for directory
File dir = new File("D:\\SomeDir");
List<File> fileList  = (List<File>)  FileUtils.listFiles(dir,suffixFileFilterFileFilter,directoryFileFilterFileFilter);
    for (File file : fileList) {
        System.out.println("file: " + file.getCanonicalPath());
    }