public static void main(String[] args) throws Exception {
    String trimm = "ABC 123|1|2 ABC '123|1|2|\"Jan 30 2018  2:34:13:000AM\"|dd1|1|\"Jan 30 2018  2:56:08:000AM\"|EST' ABC 20180821\n" +
            "ABC 123|1|2 ABC '123|1|2|\"Jan 30 2018  2:34:13:000AM\"|dd1|1|\"Jan 30 2018  2:56:08:000AM\"|EST' ABC 20180821\r\n";

    Path path = Paths.get("path");

    try (BufferedWriter writer = Files.newBufferedWriter(path))
    {
        writer.write(trimm.replaceFirst("[\n\r]+$", ""));
    }
}