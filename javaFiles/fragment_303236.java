public String convertWebsiteToPdf(ArrayList<String> htmlCode) {
        String generateHtmlPage = null;
        String fileLocation = CONST_FILE_PATH; // path to save the PDFs
        generateHtmlPage = htmlCode.toString();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(fileLocation);
                HtmlConverter.convertToPdf(generateHtmlPage, fileOutputStream);
                fileOutputStream.close();
            } catch (Exception e) {
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileLocation;
    }