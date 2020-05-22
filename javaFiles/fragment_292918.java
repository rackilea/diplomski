boolean printDocument(Document d) {
  if (PrintingSingleton.INSTANCE.isPrinterEnabled()) {
    PrintingSingleton.INSTANCE.print(d);
  }
  throw new RuntimeExeption("Printing not enabled");
}