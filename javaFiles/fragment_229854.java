PDDocument doc = PDDocument.load(new File("Mississauga_Advantages.pdf"));
for (int p = 0; p < doc.getNumberOfPages(); ++p)
{
    PDPage page = doc.getPage(p);
    List<PDAnnotation> annotations = page.getAnnotations();
    for (PDAnnotation ann : annotations)
    {
        if ("RichMedia".equals(ann.getSubtype()))
        {
            COSArray array = (COSArray) ann.getCOSObject().getObjectFromPath("RichMediaContent/Assets/Names/");
            String name = array.getString(0);
            COSDictionary filespec = (COSDictionary) array.getObject(1);
            PDComplexFileSpecification cfs = new PDComplexFileSpecification(filespec);
            PDEmbeddedFile embeddedFile = cfs.getEmbeddedFile();
            System.out.println("page: " + (p+1) + ", name: " + name + ", size: " + embeddedFile.createInputStream().available());
        }
    }
}