OPCPackage pkg = OPCPackage.open(path);
Workbook wb = new XSSFWorkbook(pkg);

// use the workbook

// When you no longer needed it, immediately close and release the file resources
pkg.close();