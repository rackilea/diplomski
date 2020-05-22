public void upload(ActionRequest request, ActionResponse response)
    throws Exception {

    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
    long sizeInBytes = uploadRequest.getSize(fileInputName);

    if (sizeInBytes == 0) {
        throw new Exception("Received file is 0 bytes!");
    }

    File uploadedFile = uploadRequest.getFile(fileInputName);
    String sourceFileName = uploadRequest.getFileName(fileInputName);

    /* selected folder from UI */
    String paramFolder = uploadRequest.getParameter("folder");

    byte[] bytes = FileUtil.getBytes(uploadedFile);

    if (bytes != null && bytes.length > 0) {
        try {
            /* Create folder if doesn't exist */
            File folder = new File(baseDir + File.separator + paramFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }

            /* Write file to specified location */
            File newFile = new File(folder.getAbsolutePath() + File.separator + sourceFileName);            
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            fileOutputStream.write(bytes, 0, bytes.length);
            fileOutputStream.close();           
            newFile = null;

        } catch (FileNotFoundException fnf) {
            newFile = null;
            /* log exception */
        } catch (IOException io) {
            newFile = null;
            /* log exception */
        }
    }
}