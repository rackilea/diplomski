public static void main(String[] args) throws IOException {
    File result = new File("C:/temp/result.txt");
    OutputStream os = new FileOutputStream(result);
    Collection<File> files = FileUtils.listFiles(
            new File("C:/temp/dir"),
            new RegexFileFilter("^(.*?)"),
            DirectoryFileFilter.DIRECTORY
    );
    for(File f: files){
        //path to file surrounded by ===
        IOUtils.writeLines(
                Arrays.asList("===", f.getAbsolutePath(), "==="),
                "\r\n",
                os,
                Charset.defaultCharset());
        //file contents
        IOUtils.copy(new FileInputStream(f), os);
    }
}