Set<String> names = new HashSet<>();
for (String file : fileNames) {

    // ...

    String name = resource.getFilename();
    String originalName = name;
    for (int i = 1; ! names.add(name); i++)
        name = originalName + "_" + i;
    ZipEntry e = new ZipEntry(name);

    // ...

}