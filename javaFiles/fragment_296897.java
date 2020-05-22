byte[] pdfdata = GetPDFData();

        File tempFile = File.createTempFile("twiqd", ".pdf");
        FileOutputStream tempOut = new FileOutputStream(tempFile);
        tempOut.write(pdfdata);
        tempOut.close();

        browser.setUrl(tempFile.toURI().toURL().toExternalForm());
        shell.pack();
        etc.