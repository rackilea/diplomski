final String[]  file_ext = new String[] {"ext1", "ext2", "ext3"};

FilenameFilter filter = new FilenameFilter() {

    @Override
    public boolean accept(File dir, String name) {
            for(int i=file_ext.length-1;i>=0;i--)
                if( name.endsWith( "." + file_ext[i]) )
                    return true;
            return false;
        }
    };

File file = new File(directoryPath);
List<File> filesList = new LinkedList<File>(Arrays.asList(file.listFiles(filter)));