for (File f1 : filesList1) {
    if (f1.isFile()) {
        for (File f2 : filesList2) {
            if (f2.isFile() && f1.getName().equals(f2.getName())) {
               //adding same name files here.
                commonfiles.add(f1.getName());
            }
        }
    }
}