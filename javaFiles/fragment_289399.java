File[] files = maindir.listFiles();
    System.out.println("Files count: " + files.length);
    for (int i = 0; i < files.length; i++) {
        System.out.print(files[i].getAbsolutePath());
        if (files[i].isDirectory()) {
            System.out.println(" dir");
        } else if (files[i].isFile()) {
            System.out.println(" file");
        }
    }