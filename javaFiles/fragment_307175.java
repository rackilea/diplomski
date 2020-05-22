/**
 * 
 * @param service google drive instance
 * @param titles list of folders titles 
 * i.e. if your path like this folder1/folder2/folder3 then pass them in this order createFoldersPath(service, folder1, folder2, folder3)
 * @return parent reference of the last added folder in case you want to use it to create a file inside this folder.
 * @throws IOException
 */
private List<ParentReference> createFoldersPath(Drive service,String...titles) throws IOException
{
    List<ParentReference> listParentReference = new ArrayList<ParentReference>();
    File file = null;
    for(int i=0;i<titles.length;i++)
    {
        file = getExistsFolder(service, titles[i], (file==null)?"root":file.getId());
        if (file == null)
        {
            file = createFolder(service, titles[i], listParentReference);
        }
        listParentReference.clear();
        listParentReference.add(new ParentReference().setId(file.getId()));
    }
    return listParentReference;
}