class MyFilenameFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
        return name.startsWith("gene_") && name.endsWith("_info.info"); 
    }
}

FilenameFilter filter = new MyFilenameFilter()