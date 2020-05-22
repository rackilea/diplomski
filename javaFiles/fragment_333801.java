import org.xhtmlrenderer.pdf.ITextRenderer;
public class MyAbstractView extends AbstractView {
   OutputStream os;

   public void buildPdfDocument(Map<String,Object> model, com.lowagie.text.Document document, com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest request, HttpServletResponse response){
   //process model params
   os = new FileOutputStream(outputFile);
   ITextRenderer renderer = new ITextRenderer();
   String url = "http://www.mysite.com"; //set your sample url namespace here
   renderer.setDocument(document, url); //use the passed in document
   renderer.layout();
   renderer.createPDF(os);
   os.close();
   }
}

protected final void renderMergedOutputModel(Map<String,Object> model,
                                         HttpServletRequest request,
                                         HttpServletResponse response)
                                  throws Exception{
 if(os != null){
  response.outputStream = os;
 }

public byte[] getPDFAsBytes(){
  if(os != null){
     byte[] stuff;
     os.write(stuff);
     return stuff;
  }
}