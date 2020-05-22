public static class DirFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        if( pathname.isDirectory() ) 
            return true;

        return false;
    }

}