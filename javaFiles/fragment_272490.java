protected void recurseFolders(final Folder folder) {
    // folder can hold messages
    if ((folder.getType() & Folder.HOLDS_MESSAGES) != 0) {

        // process them

    }

    // folder can hold other folders
    if ((folder.getType() & Folder.HOLDS_FOLDERS) != 0) {
        for (final Folder subfolder : folder.list()) {

            // process them recursive
            recurseFolders(subfolder);

        }
    }

}