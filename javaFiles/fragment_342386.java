public static void main(String[] args) {
    String trimm = "ABC 123|1|2 ABC '123|1|2|\"Jan 30 2018  2:34:13:000AM\"|dd1|1|\"Jan 30 2018  2:56:08:000AM\"|EST' ABC 20180821\n" +
            "ABC 123|1|2 ABC '123|1|2|\"Jan 30 2018  2:34:13:000AM\"|dd1|1|\"Jan 30 2018  2:56:08:000AM\"|EST' ABC 20180821\r\n";

    try {
        Files.write(Paths.get("path"), trimm.replaceFirst("[\n\r]+$", "").getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
}