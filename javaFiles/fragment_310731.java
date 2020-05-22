public static void tieOutputStreams(String fileName) {
    try {
        File output = new File(fileName);
        outputStream = new TiedOutputStream(output);
        System.setErr(outputStream);
        System.setOut(outputStream);
    } catch (Exception e) {
        e.printStackTrace();
    }

}