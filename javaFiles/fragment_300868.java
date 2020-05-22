Button downloadLogButton = new Button("downloadlogbutton") {
    private static final long serialVersionUID = 1L;
    @Override
    public void onSubmit() {
        // Some utility class I made that zips files
        LogUtility util = new LogUtility();
        util.zipLogFiles("sample", logs);
        IResourceStream resourceStream = new FileResourceStream(
            new org.apache.wicket.util.file.File(someFile)); // Use whatever file you need here
        IRequestTarget t = new ResourceStreamRequestTarget(stream){
            @Override
            public String getFileName() {
                return "filename.zip";
            }
        }
        getRequestCycle().setRequestTarget(t);
    }
};