String rootPath = <path_to_root>;
    File[] domains = new File(rootPath).listFiles();
    for (File domain : domains) {
        if (domain.isDirectory()) {
            File[] files = new File(domain.getAbsolutePath()).listFiles();
            for (File file : files) {
                if (file.isFile() && file.getAbsolutePath().endsWith(".mkv")) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }