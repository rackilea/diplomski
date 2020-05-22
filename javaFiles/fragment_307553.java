Arrays.asList(filelist).parallelStream().forEach((filepath) -> {
    Path source = Paths.get(filepath);
    Path target = Paths.get(FileBrowser.destinationpath+"/"+filepath]);
    try {
        //replace existing file using java nio package
        System.out.println(Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING));
    } catch (IOException e) {
        e.printStackTrace();
    }
});