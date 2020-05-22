public static long getgFolderSize(final File... selectedDirectories){
    long foldersize = 0;
    for(final File item : selectedDirectories){
        for(final File subItem : item.listFiles()){
            if(subItem.isDirectory()){
                foldersize += getFolderSize(subItem);
            } else{
                foldersize += subItem.length();
            }
        }
    }
    return foldersize;
}