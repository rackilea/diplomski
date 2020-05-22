try {
    PdfReader reader = new PdfReader("src/file.pdf");
    PdfStamper stamper =  new PdfStamper(reader, new FileOutputStream("c:/Users/Gabriel/Desktop/"+txtName.getText().toString()+".pdf"));
    AcroFields form = stamper.getAcroFields();
    ..code..
    stamper.close();
}