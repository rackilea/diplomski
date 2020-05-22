List tokens = parser.getTokens();  
for (int j = 0; j < tokens.size(); j++)  
{  
    Object next = tokens.get(j); 
    if (next instanceof PDFOperator)
    {
        PDFOperator op = (PDFOperator) next;  
        // Tj and TJ are the two operators that display strings in a PDF  
        if (op.getOperation().equals("Tj"))  
        { 
            tokens.set(j-1, COSInteger.get(3));
            tokens.set(j, PDFOperator.getOperator("Tr"));
            tokens.add(++j, new COSString("hello"));
            tokens.add(++j, PDFOperator.getOperator("Tj"));
            tokens.add(++j, COSInteger.get(0));
            tokens.add(++j, PDFOperator.getOperator("Tr"));
            tokens.add(++j, new COSString(" world"));
            tokens.add(++j, PDFOperator.getOperator("Tj"));
        }
    }      
}