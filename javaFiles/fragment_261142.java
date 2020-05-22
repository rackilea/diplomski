// Todo: Set tree to root if filename starts with /

for (int i = 0; i < size; i++) {
    File f = tree.getFile(dirSplit[i]);
    if (f == null) {
        tree.mkdir(dirSplit[i]);
        f = tree.getFile(dirSplit[i]);
    }
    // Todo: Handle f not instance of Directory
    tree.setWDir((Directory) f);
   }