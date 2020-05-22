PrintWriter printWriter = response.getWriter();
    try {
        ServletContext context = request.getSession().getServletContext();
        String pdffiles = context.getRealPath("/WEB-INF/");

        File readPath = new File(pdffiles);
        if (readPath.exists()) {
            String pdfFile = "04-Request-Headers.pdf"; // read this file to save in savedpdffiles folder
            File savedPath = new File(readPath.getAbsolutePath() +"/savedpdffiles/"); // create savedpdffiles folder under WEB-INF folder

            File readFullPath = new File(readPath.getAbsolutePath() + File.separatorChar + pdfFile);
            if (readFullPath.isFile()) {
                if(!savedPath.exists()) {
                    savedPath.createNewFile();// create new pdf file if not exits
                    printWriter.println( savedPath.getName() +" File created in -> "+ savedPath.getAbsolutePath());
                }

                PDDocument document = new PDDocument();
                PDDocument sourceDocument = PDDocument.load(readFullPath.getAbsolutePath()); // read the pdf file by PDDocument
                PDPage templatePdfPage = (PDPage) sourceDocument.getDocumentCatalog().getAllPages().get(0); // only first page is read out of 13 pages and save the first page.
                document.addPage(templatePdfPage);
                document.save(savedPath + "/" + pdfFile);
                document.close();
                sourceDocument.close();
                printWriter.print(pdfFile + " File saved to this location-> "+ savedPath.getAbsolutePath() + File.separatorChar + pdfFile);
            } else {
                printWriter.println(readFullPath.getName() + " File not exits in -> "+ readFullPath.getAbsolutePath());
            }
        } else {
            printWriter.println("Path not exists -> "+ readPath.getAbsolutePath());
        }
    } catch (Exception e) {
        printWriter.print("Type of Error occured while saving the PDF file -> "+ e.getMessage());
        e.printStackTrace();
    }