/**
     * @param originalFilePath PDF to append to
     * @param fileToInsertPath PDF to append
     * @param outputFile Where to save to
     * @param location where you want to insert the page
     */
    public static void mergePDFs(String originalFilePath, String fileToInsertPath, String outputFile, int location) {

        PdfReader originalFileReader = null;
        try {
            originalFileReader = new PdfReader(originalFilePath);
        } catch (IOException ex) {
            System.out.println("ITextHelper.addPDFToPDF(): can't read original file: " + ex);
        }
        PdfReader fileToAddReader = null;
        try {
            fileToAddReader = new PdfReader(fileToInsertPath);
        } catch (IOException ex) {
            System.out.println("ITextHelper.addPDFToPDF(): can't read fileToInsert: " + ex);
        }

        if (originalFileReader != null && fileToAddReader != null) {

            // -- Copy
            int numberOfOriginalPages = originalFileReader.getNumberOfPages();
            Document document = new Document();
            PdfCopy copy = null;
            try {
                copy = new PdfCopy(document, new FileOutputStream(outputFile));
                document.open();

                for (int i = 1; i <= numberOfOriginalPages; i++) {
                    if (i == location) {
                        for (int j = 1; j <= fileToAddReader.getNumberOfPages(); j++) {
                            copy.addPage(copy.getImportedPage(fileToAddReader, j));
                        }
                    }
                    copy.addPage(copy.getImportedPage(originalFileReader, i));

                }
                document.close();
            } catch (DocumentException | FileNotFoundException ex) {
                System.out.println("ITextHelper.addPDFToPDF(): can't read output location: " + ex);
            } catch (IOException ex) {
                Logger.getLogger(ITextHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }