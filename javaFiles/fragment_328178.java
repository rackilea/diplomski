public static void main(String[] args) {
    String file = System.getProperty("user.home") + File.separator + "temp.txt";
    try {
        System.out.println(Arrays.deepToString(readMatrixFrom(file)));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}