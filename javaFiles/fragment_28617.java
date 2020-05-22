JTextPane textPane = new JTextPane();
StyledDocument doc = textPane.getStyledDocument();

//  Define a keyword attribute
SimpleAttributeSet keyWord = new SimpleAttributeSet();
StyleConstants.setBold(keyWord, true);

Style style = doc.addStyle("StyleName", null);
//StyleConstants.setIcon(style, new ImageIcon(qrcode));

doc.insertString(0, "Title Here\n", null);
doc.insertString(doc.getLength(), "Ignored", style);

Paper paper = new Paper();
paper.setSize(fromCMToPPI(21.0), fromCMToPPI(29.7)); // A4
paper.setImageableArea(fromCMToPPI(5.0), fromCMToPPI(5.0), 
                fromCMToPPI(21.0) - fromCMToPPI(10.0), fromCMToPPI(29.7) - fromCMToPPI(10.0));

PageFormat pageFormat = new PageFormat();
pageFormat.setPaper(paper);

PrinterJob pj = PrinterJob.getPrinterJob();
pj.setPrintable(textPane.getPrintable(null, null), pageFormat);
PageFormat pf = pj.pageDialog(pageFormat);
if (pj.printDialog()) {
    pj.print();
}