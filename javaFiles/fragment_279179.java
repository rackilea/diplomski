PdfReader pdfReader = null;
    try{
            Document.plainRandomAccess=true;
            pdfReader = new PdfReader(new RandomAccessFileOrArray("D://bigfile.pdf"),null);
    }catch(Exception e){
            System.out.println("Error");
            e.printStackTrace();
    }