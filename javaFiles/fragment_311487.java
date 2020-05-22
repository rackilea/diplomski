public static class RBCFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        String suffix = ".rbc";
        if( pathname.getName().toLowerCase().endsWith(suffix) ) {
            return true;
        }
        return false;
    }

}