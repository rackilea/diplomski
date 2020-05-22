public void ls(File f) {
    System.out.println(f); //or whatever is needed to print the filename
    if(f instanceof Directory) {
        List<File> fileList = ((Directory)f).getFiles();

        //with Java 8
        fileList.forEach(subFile -> System.out.println(subFile));
        fileList.forEach(subFile -> ls(subFile));

        //without Java 8
        for(File subFile : fileList) {
            System.out.println(subFile);
        }
        for(File subFile : fileList) {
            ls(subFile);
        }


        System.out.println();
    }
}