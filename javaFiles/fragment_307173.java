/**
     * 
     * @param service google drive instance
     * @param title the title (name) of the folder (the one you search for)
     * @param parentId the parent Id of this folder (use root) if the folder is in the main directory of google drive
     * @return google drive file object 
     * @throws IOException
     */
    private File getExistsFolder(Drive service,String title,String parentId) throws IOException 
    {
        Drive.Files.List request;
        request = service.files().list();
        String query = "mimeType='application/vnd.google-apps.folder' AND trashed=false AND title='" + title + "' AND '" + parentId + "' in parents";
        Logger.info(TAG + ": isFolderExists(): Query= " + query);
        request = request.setQ(query);
        FileList files = request.execute();
        Logger.info(TAG + ": isFolderExists(): List Size =" + files.getItems().size());
        if (files.getItems().size() == 0) //if the size is zero, then the folder doesn't exist
            return null;
        else
            //since google drive allows to have multiple folders with the same title (name)
            //we select the first file in the list to return
            return files.getItems().get(0);
    }