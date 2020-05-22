// Zip
                ZipOutputStream zipOut = ...
                zipOut.setMethod(ZipOutputStream.STORED); // No compression.

                for(int i = 0; i < tableModel.getRowCount(); i++) {
                    // Single file
                    File originalFile = (File) tableModel.getValueAt(i, 0);
                    FileInputStream originalStream = new FileInputStream(originalFile);

                    // GZipped single file:
                    GZipOutputStream gzipOut = ...; ...

                    // Input of the gzipped thing
                    InputStream gzipResultIn = ...


                    // Make a new ZipEntry:
                    ZipEntry zipEntry = new ZipEntry(originalFile.getName()
                            + ".gz.enc");
                    zipOut.putNextEntry(zipEntry);
                    encrypt(key, gzipResultIn, zipOut); // Should not close the input
                    zipOut.closeEntry();
                }

                zipOut.close();