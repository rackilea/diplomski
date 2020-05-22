public static void printAttachmentPartZip(AttachmentPart att) throws IOException, SOAPException {
    try (ZipInputStream zis = new ZipInputStream(att.getRawContent())) {
        byte[] buffer = new byte[1024];
        for (ZipEntry zipEntry = zis.getNextEntry(); zipEntry != null; zipEntry = zis.getNextEntry()) {
            if (zipEntry.isDirectory()) {
                continue;
            }
            System.out.println(zipEntry.getName());
            for (int len = zis.read(buffer); len > 0; len = zis.read(buffer)) {
                System.out.write(buffer, 0, len);
            }
        }
    }
}