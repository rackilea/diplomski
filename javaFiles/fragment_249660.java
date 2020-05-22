public static String ImageToPDF(byte[] bytes, String pathFile) {
        String fileName= pathFile + ".pdf";
        Document document = null;

            document = new Document();

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            PdfWriter writer = PdfWriter.getInstance(document, fos);

            writer.open();
            document.open();

            // Array of bytes we have read from the Binary file
            RandomAccessFileOrArray ra = new RandomAccessFileOrArray(bytes);

            // Get the number of pages the the binary file have inside
            int numberOfPages = TiffImage.getNumberOfPages(ra);

            // Loop through numberOfPages and add them on the document 
            // one by one
            for(int page = 1; page <= numberOfPages; page ++){
                Image image = TiffImage.getTiffImage(new RandomAccessFileOrArray(bytes),page);
                image.scaleAbsolute(500, 500);
                document.add(image);
            }                   

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;

}