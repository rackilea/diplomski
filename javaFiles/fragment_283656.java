response.setProperty("Content-Disposition", "attachment; filename=myarchive.zip");
    response.setContentType("application/zip");

    final ZipWriter writer = ZipWriterFactoryUtil.getZipWriter();

    for (String filename : xmls) {
        byte[] file = FileUtil.getBytes(new File("filename"));
        writer.addEntry(filename, file);
    }

    byte[] archive = writer.finish();
    response.getPortletOutputStream().write(archive);