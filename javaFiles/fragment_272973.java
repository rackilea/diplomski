OPCPackage opc = OPCPackage.open(file);
XSSFReader xssfReader = new XSSFReader(opc);
SharedStringsTable sst = xssfReader.getSharedStringsTable();
XSSFReader.SheetIterator itr = (XSSFReader.SheetIterator)xssfReader.getSheetsData();
while(itr.hasNext()) {
    InputStream sheetStream = itr.next();
    if(itr.getSheetName().equals(sheetName)) {  // Or you can keep track of sheet numbers
        in = sheetStream;
        return;
    } else {
        sheetStream.close();
    }
}