List<PdfPTable> results = Stream.<Supplier<PdfPTable>>.of(
    ()  -> populateSection1(arguments),
    ()  -> populateSection2(arguments));
    ...
    () -> populateSection10(arguments)))
    .parallel()
    .map(Supplier::get)
    .filter(Objects::nonNull)
    .forEachOrdered(el -> populatePdfElement(document, el));