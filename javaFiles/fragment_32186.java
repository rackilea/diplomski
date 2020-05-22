List<POLine> list = 
    poSearchResponseList.stream()
                        .flatMap(posr -> posr.getDeliveryDocumentLines()
                                             .stream()
                                             .map(dl -> 
                                                 POLine.builder()
                                                       .poLineNumber(dl.getPurchaseReferenceLineNumber())
                                                       .quantity(deliveryDocumentLine.getExpectedQty())
                                                       .vnpkQty(deliveryDocumentLine.getVnpkQty())
                                                       .build()))
                        .collect(Collectors.toList());