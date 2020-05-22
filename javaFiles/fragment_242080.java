List<PdfPTable> results = Stream.of(section1Future, section2Future, ..., section10Future)
    .map(CompletableFuture::join)
    .filter(Objects::nonNull)
    .collect(Collectors.toList());

results.forEach(el -> populatePdfElement(document, el));