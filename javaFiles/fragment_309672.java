//... all files zipped

for (File file : listFiles) {
    if (!file.delete()) {
      file.deleteOnExit();
    }
}

//... remove the parent folder if you wish, the same way as above