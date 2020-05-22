public static void printArrayAndIntegerCount(Integer[] array, String filename) {
    try (PrintWriter pw = new PrintWriter(filename);) {
        pw.println("number of integers in file \"" + filename+ "\" = " + array.length);
        for (int i=0; i<array.length; i++) {
            pw.println("    index = " + i + "; element = " + array[i]);
        }
    }
    catch (Exception e) {
        //handle exceptions
    }
}