public ArrayList<String> getFolders(String foldername)
{
  ArrayList<String> retval = new ArrayList<String>();
  retval.add(foldername);
  ArrayList<String> subfolders = ftpPrintDirsList(foldername);
  for (String folder : subfolders)
    retval.addall(getFolders(foldername + folder));
  return retval;
}