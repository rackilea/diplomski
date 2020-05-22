DocFlavor flavor = DocFlavor.INPUT_STREAM.POSTSCRIPT;
PrintRequestAttributeSet aset = new HashPrintRequestHashAttributeSet();
aset.add(MediaSizeName.ISO_A4);
PrintService[] pservices =PrintServiceLookup.lookupPrintServices(flavor, aset);
if (pservices.length > 0) {
    DocPrintJob pj = pservices[0].createPrintJob();
    //....
}