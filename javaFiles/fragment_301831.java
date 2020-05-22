PdfReader reader = new PdfReader(byteArrayOutputStream.toByteArray());  
List<TextRenderInfoObject> textRenderInfos = new ArrayList<>();  
PdfReaderContentParser parser = new PdfReaderContentParser(reader);  
parser.processContent(pageNumber, new TextMarginFinder()
{
    @Override  
    public void renderText(TextRenderInfo renderInfo)
    {  
        if("dstext".contains(renderInfo.getText()))
        {  
            textRenderInfos.add(new TextRenderInfoObject(  
            renderInfo.getText(), renderInfo));
        }
    }
}

Rectangle2D.Float line;  
for (TextRenderInfoObject textRenderInfo : textRenderInfos)  
{
    if (textRenderInfo.getText().equals("dstext"))  
        line = textRenderInfo.getLine().getBaseline().getBoundingRectange());
}