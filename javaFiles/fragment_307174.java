/**
 * 
 * @param service google drive instance
 * @param title the folder's title
 * @param listParentReference the list of parents references where you want the folder to be created, 
 * if you have more than one parent references, then a folder will be created in each one of them  
 * @return google drive file object   
 * @throws IOException
 */
private File createFolder(Drive service,String title,List<ParentReference> listParentReference) throws IOException
{
    File body = new File();
    body.setTitle(title);
    body.setParents(listParentReference);
    body.setMimeType("application/vnd.google-apps.folder");
    File file = service.files().insert(body).execute(); 
    return file;

}