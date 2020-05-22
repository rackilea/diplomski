//loop iteration
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("Hello World!"));
        //process the document.
        ...
        //save the document.
        ...
        // step 5
        document.close();
        //next loop iteration