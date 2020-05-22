public class PDF extends AbstractPdfStamperView {

    @Override
    protected void mergePdfDocument(Map<String, Object> model, PdfStamper stamper, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        Result result = (Result)model.get("result");

        AcroFields form = stamper.getAcroFields();
//map form fields