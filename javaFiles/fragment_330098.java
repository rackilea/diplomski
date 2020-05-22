org.odftoolkit.odfdom.converter.pdf.PdfOptions options = new PdfOptions();
options.setConfiguration( new IPdfWriterConfiguration()
{

  public void configure( PdfWriter writer )
  {
    writer.setEncryption(...);
  }
});
PdfConverter.getInstance().convert( document, out, options );