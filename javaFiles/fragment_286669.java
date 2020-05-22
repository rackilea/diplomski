this.Inq.stream().filter(simInq -> !simInq.isClosed() && !simInq.isDenied())
  .forEach(simInq -> Quotations.values().stream().filter(sapQuot ->
   sapQuot.getInquiryDocumentNumber().compareTo(simInq.getSapInquiryNumber())==0)
   .forEach(sapQuot -> {
      simInq.setSAPQuotationNumber(sapQuot.getQuotationDocumentNumber());
      tempInqAndQuot.add(simInq);
      tempQuotPos.addAll(sapQuot.getPosition().values());
    })
  );