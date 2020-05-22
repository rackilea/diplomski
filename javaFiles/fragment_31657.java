//Define the location of the PDF and establish a new file to write to. We will change the target later//
    String dest = System.getProperty("user.home").concat("directory_and_name_of_PDF.pdf");
    String out = System.getProperty("user.home").concat("directory_and_name_that_will_be_changed.pdf");
    PdfReader pdfreader = new PdfReader(dest);                 
    PdfStamper stamper = new PdfStamper(pdfreader, new FileOutputStream(System.getProperty("user.home").concat("same_as_String out")));       
    AcroFields form = stamper.getAcroFields();  

//Append text to the text fields//
    form.setField("text field name", "text to add");
    form.setField("text field name2", "repeat");
    form.setField("text field name3", "repeat");
    form.setField("text field name4", "repeat");
    stamper.close();
    pdfreader.close();

//Change the file name of fileOutputStream to the original that was read from//
    File destfile = new File(dest);
    File outfile = new File(out);
    destfile.delete();        
    outfile.renameTo(new File(System.getProperty("user.home").concat("name_of_the_original_PDF.pdf")));