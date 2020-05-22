try (ZipOutputStream zipStream = new ZipOutputStream(
                                   new DigestOutputStream(
                                     new FileOutputStream(zipFile),
                                     digest))) {
    // code adding zip entries here
}
String checksum = Hex.encodeHexString(digest.digest());