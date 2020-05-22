protected ITagWriter writer = null;

private void init() throws IOException {
    file = new File(OmFileHelper.getStreamsSubDir(this.scope.getName()), this.streamName + ".flv");

    IStreamableFileFactory factory = (IStreamableFileFactory) ScopeUtils
            .getScopeService(this.scope, IStreamableFileFactory.class,
                    StreamableFileFactory.class);

    if (!this.file.isFile()) {
        // Maybe the (previously existing) file has been deleted
        this.file.createNewFile();

    } else if (!file.canWrite()) {
        throw new IOException("The file is read-only");
    }

    IStreamableFileService service = factory.getService(this.file);
    IStreamableFile flv = service.getStreamableFile(this.file);
    this.writer = flv.getWriter();

}