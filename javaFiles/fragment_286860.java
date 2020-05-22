Say the text is: "আমার পথ চলা আমার পথে যেনো বেলা শেষে হারায় পথে আমার স্বপ্ন আমার সাথে থাকে স্বপ্নের ভিরে থাকে স্বপ্ন হয়ে রোদ্দুর খুঁজে পাই জীবনের"

And i want to show it in two line as:
আমার পথ চলা আমার পথে যেনো বেলা শেষে হারায় পথে আমার স্বপ্ন
আমার সাথে থাকে স্বপ্নের ভিরে থাকে স্বপ্ন হয়ে রোদ্দুর খুঁজে পাই জীবনের"

then I break it into 4 parts.
txt1="আমার পথ চলা আমার পথে যেনো বেলা শেষে হারায় পথে"
txt2="                                           আমার স্বপ্ন"
txt3="আমার সাথে থাকে স্বপ্নের ভিরে থাকে স্বপ্ন হয়ে রোদ্দুর খুঁজে"
txt4="                                          পাই জীবনের"




    PdfPCell c1 = new PdfPCell();
    c1.setFixedHeight(hght);
    c1.setHorizontalAlignment(Element.ALIGN_RIGHT);
    ITextUtil.setCellBorder(c1, 0, 0, 1, 0);
    ITextUtil.setCellPadding(c1, 0, 7, 0, 0);




    Paragraph phrs1 = new Paragraph(txt1, fnt);
    phrs1.setLeading(12);
    c1.addElement(phrs1);



    Paragraph phrs2 = new Paragraph(txt2, fnt);
    phrs2.setLeading(0);
    c1.addElement(phrs2);


    Paragraph phrs3 = new Paragraph(txt3, fnt);
    phrs3.setLeading(11);
    c1.addElement(phrs3);


    Paragraph phrs4 = new Paragraph(txt4, fnt);
    phrs4.setLeading(0);
    c1.addElement(phrs4);