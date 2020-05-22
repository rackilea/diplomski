public static void writeToFile(String filename, Iterable<String> strings) {
    try (PrintWriter pw = new PrintWriter(filename)) {
       for(String str : strings)
            pw.println(str);
    }
}