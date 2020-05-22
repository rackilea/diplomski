class CompositeFileExtension implements FileExtension {

    private List<FileExtension> fileExtensions;

    public CompositeFileExtension() {
        //in the real world, this list can be populated through an IoC container
        fileExtensions = new ArrayList<FileExtension>();
        fileExtensions.add(new PNGExtension());
        fileExtensions.add(new JPGExtension());

    }

    @Override
    public String getExtension(byte[] buffer) {
        String fileExtension = null;
        for(FileExtension extension : fileExtensions) {
            if((fileExtension=extension.getExtension(buffer))!=null) {
                break;
            }
        }

        return fileExtension;
    }
}