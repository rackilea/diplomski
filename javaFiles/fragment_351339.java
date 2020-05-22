File folder = new File("folder_path_to_delete");
    ArrayList<File> foldersToDelete = listFolders(folder);
    foldersToDelete.add(folder);
    for(File folderToDelete : foldersToDelete) {
        folderToDelete.delete();
    }
    System.out.println(foldersToDelete + "  deleted");