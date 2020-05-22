public static void showFiles(File[] files) {
    for (File file : files) {
        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
            try {
                File[] dirFiles = file.listFiles();
                if (dirFiles == null) {
                    System.out.println("Not a directory, or I/O error: " + file.getName());
                }
                else if (dirFiles.length == 0) { //simple recursion would not recognize this case
                    System.out.println("Directory is empty: " + file.getName());
                }
                else {
                    showFiles(dirFiles); // Calls same method again.
                }
            }
            catch (SecurityException exc) {
                System.out.println("SecurityException with: " + file.getName());
            }
        }
        else {
            System.out.println("File: " + file.getName());
        }
    }
}