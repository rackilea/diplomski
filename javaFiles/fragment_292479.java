public static void findAndAppend(File parent, BufferedWriter bw) throws IOException {

    // Find any matching files...  
    File files[] = parent.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().equals("part1.txt");
        }
    });

    // Append any results...technically there should only be 0-1 
    // matches, but this is a nice example ;)
    for (File file : files) {
        append(file, bw);
    }

    // Find the sub directories...
    File dirs[] = parent.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    });

    // Scan the sub directories...
    for (File dir : dirs) {
        findAndAppend(dir, bw);
    }

}