FileSet fs;
// ...
DirectoryScanner ds = fs.getDirectoryScanner(getProject());
String[] includedFiles = ds.getIncludedFiles();
for(int i=0; i<includedFiles.length; i++) {
    String filename = includedFiles[i].replace('\\','/');
    ...
}