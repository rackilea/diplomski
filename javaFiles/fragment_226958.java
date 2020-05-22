public void exampleMethod() throws Exception {
    File[] files = someFile.listFiles();
    if(files == null) {
        throw new Exception("File is not a directory, and as such cannot list files");
        //You can also create your own exception class (extends Exception), and explicitly throw that, rather than just a general Exception
        return;
    }

}