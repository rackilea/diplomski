String printName = "HP Officejet Pro 8500 A910 (Network)";
AttributeSet aset = new HashAttributeSet();
aset.add(new PrinterName(printName, null));
PrintService[] services = PrintServiceLookup.lookupPrintServices(null, aset);
for (int i = 0; i < services.length; i++) {
  PrintService service = services[i];
  System.out.println(service);
  DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
  Object o = service.getSupportedAttributeValues(Media.class, flavor, null);
  if (o != null && o.getClass().isArray()) {
    for (Media media : (Media[]) o) {
      System.out.println(media + " ID: " + media.getValue() + "\t" + media.getClass().getName());
    }
  }
}