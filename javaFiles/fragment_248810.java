JFileChooser fc = new JFileChooser();
fc.setFileFilter(new FileFilter(){
    @Override
    public boolean accept(File file){
        // always accept directorys
        if(file.isDirectory())
            return true;
        // but only files with specific name _SomeFixedFormat.def
        return file.getName().equals("_SomeFixedFormat.def");
    }
    @Override
    public String getDescription() {
        return ".def";
    }
});