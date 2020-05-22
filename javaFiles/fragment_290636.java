public static void writeList(List<Double> al) {
    File f = new File(System.getProperty("user.home"), "out.txt");
    try (PrintWriter pw = new PrintWriter(f)) {
        for (Double d : al) {
            pw.println(d);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}