try {
        PdfReader reader = new PdfReader("D:\\hl_sv\\L09MF.pdf");
        int pagenumber = reader.getNumberOfPages();
        PrintWriter out = new PrintWriter("D:\\hl_sv\\L09MF.txt");

        for (int i = 1; i <= pagenumber; i++) {
            System.out.println("==================PAGE NUMBER " + i
                    + "===================");
            String line = PdfTextExtractor.getTextFromPage(reader, i);



            for (String s : line.split("\n")) {
                out.println(s);
            }



            System.out.println(line);
        }
    out.close();