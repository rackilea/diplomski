public static void mergePdfs(){
     try {
          String[] files = { "D:\\1.pdf" ,"D:\\2.pdf"  ,"D:\\3.pdf" ,"D:\\4.pdf"};
          Document pDFCombineUsingJava = new Document();
          PdfCopy copy = new PdfCopy(pDFCombineUsingJava , new FileOutputStream("D:\\CombinedFile.pdf"));
          pDFCombineUsingJava.open();
          PdfReader ReadInputPDF;
          int number_of_pages;
          for (int i = 0; i < files.length; i++) {
                  ReadInputPDF = new PdfReader(files[i]);
                  copy.addDocument(ReadInputPDF);
                  copy.freeReader(ReadInputPDF);
          }
          pDFCombineUsingJava.close();
        }
        catch (Exception i)
        {
            System.out.println(i);
        }
}