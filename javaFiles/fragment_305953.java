PdfPage page = pdfDocument.getPage(1);
page.setPageLabel(PageLabelNumberingStyle.UPPERCASE_ROMAN_NUMERALS, "Cover", 1);

page = pdfDocument.getPage(2);
int pageNumToStartFrom = 2; // Replace it with 1 if you want the blocks to be numbered independently
page.setPageLabel(PageLabelNumberingStyle.DECIMAL_ARABIC_NUMERALS, null, pageNumToStartFrom);

page = pdfDocument.getPage(4);
pageNumToStartFrom = 4; // Replace it with 1 if you want the blocks to be numbered independently
page.setPageLabel(PageLabelNumberingStyle.UPPERCASE_ROMAN_NUMERALS, null, pageNumToStartFrom);