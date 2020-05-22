public void yourAction(ActionRequest request, ActionResponse response)
        throws PortletException, IOException {


    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
    String filePath = uploadRequest.getFileName("filePath");

    try{
        java.io.File file = uploadRequest.getFile("filePath");
    //Manage the Upload

    }catch (Exception e) {
        ///
    }

}