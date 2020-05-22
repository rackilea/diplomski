File[] files = new File("/home/benuni/CompileFiles/" + project + "/" + s).listFiles(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".java");
        }
    });

    StringBuilder command = new StringBuilder("javac");
    for(File file : files) {
        command.append(" ").append(file.getAbsolutePath());
    }