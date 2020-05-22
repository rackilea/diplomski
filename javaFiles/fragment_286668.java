for (ClassInq simInq : this.Inq){
        if (!simInq.isClosed() && !simInq.isDenied()){      
            for (SalesQuot sapQuot: Quotations.values()){
                if (sapQuot.getInquiryDocumentNumber().compareTo(simInq.getSapInquiryNumber()) == 0){
                    simInq.setSAPQuotationNumber(sapQuot.getQuotationDocumentNumber());
                    tempInqAndQuot.add(simInq);
                    tempQuotPos.addAll(sapQuot.getPosition().values());
                }
            }
        }
    }