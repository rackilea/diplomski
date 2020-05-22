try {
    OutputStream servletOutputStream = httpServletResponse.getOutputStream(); // retrieve OutputStream from HttpServletResponse
    ZipOutputStream zos = new ZipOutputStream(servletOutputStream); // create a ZipOutputStream from servletOutputStream

    List<String[]> csvFileContents  = getContentToZIP(); // get the list of csv contents. I am assuming the CSV content is generated programmatically
    int count = 0;
    for (String[] entries : csvFileContents) {
        String filename = "file-" + ++count  + ".csv";
        ZipEntry entry = new ZipEntry(filename); // create a zip entry and add it to ZipOutputStream
        zos.putNextEntry(entry);

        CSVWriter writer = new CSVWriter(new OutputStreamWriter(zos));  // There is no need for staging the CSV on filesystem or reading bytes into memory. Directly write bytes to the output stream.
        writer.writeNext(entries);  // write the contents
        writer.flush(); // flush the writer. Very important!
        zos.closeEntry(); // close the entry. Note : we are not closing the zos just yet as we need to add more files to our ZIP
    }

    zos.close(); // finally closing the ZipOutputStream to mark completion of ZIP file
} catch (Exception e) {
    log.error(e); // handle error
}