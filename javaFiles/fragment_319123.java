// copy annotations
PDPage src1Page = pdf1.getPage(pageNum);
PDPage src2Page = pdf2.getPage(pageNum);
for (PDAnnotation ann : src1Page.getAnnotations())
{
    outPdfPage.getAnnotations().add(ann);                
}
for (PDAnnotation ann : src2Page.getAnnotations())
{
    PDRectangle rect = ann.getRectangle();
    ann.setRectangle(new PDRectangle(rect.getLowerLeftX() + pdf1Frame.getWidth(), rect.getLowerLeftY(), rect.getWidth(), rect.getHeight()));
    outPdfPage.getAnnotations().add(ann);                
}