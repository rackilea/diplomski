public static void printAllJavaFiles(File directory) {
    if ((directory.isDirectory()) || (directory.isFile() && 
   (directory.getName().endsWith(".java")))) {
        print(directory);
        depth++;
        File[] subs = directory.listFiles();
        if(subs != null) {
            for (File f : subs) {
                printAllJavaFiles(f);
            }
        }
        depth--;
    }
}