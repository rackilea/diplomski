// array of supported extensions 
    static final String[] EXTENSIONS = new String[] { "jpg", "jpeg", "gif", "png", "bmp" };

    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    @GET
    @Path("folderImages")
    @Produces("text/json")
    public Response getFolderImages(@QueryParam("lastknown") String lastknown) 
    {
        //Gets the contents of the folder (reverse order : more recent first)
        //see http://stackoverflow.com/questions/11300847/load-and-display-all-the-images-from-a-folder
        File dir = new File("C:\\Temp\\hotfolder");
        File [] files = dir.listFiles(IMAGE_FILTER); 
        Arrays.sort( files, new Comparator<File>() {
            public int compare(File f1, File f2) {
                if (f1.lastModified() > f2.lastModified()) {
                    return -1;
                } else if (f1.lastModified() < f2.lastModified()) {
                    return +1;
                } else {
                    return 0;
                }
            }
        });
        //Fills a list (from the more recent one, until the last known file)
        ArrayList<String> newfiles = new ArrayList<String>();
        for (File f : files)
        {
            if (lastknown!=null && f.getName().equals(lastknown)) 
                break;
            newfiles.add(f.getName());
        }
        //Answers the list as a JSON array (using google-gson, but could be done manually here)
        return Response.status(Status.OK).entity(new Gson().toJson(newfiles)).type("text/json").build();
    }