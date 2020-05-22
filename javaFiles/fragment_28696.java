String dir = "/my/full/path/to/folder/";
for (int i = 0; i < _files.size(); i++) {
...
    if (_files.get(i).getAbsolutePath().contains(".")) {
        entry = new ZipEntry(_files
            .get(i).getAbsolutePath().replace(dir, ""));
...