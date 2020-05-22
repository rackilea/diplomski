JAXBContext jc = JAXBContext.newInstance(BuyerResponse.class);
    Unmarshaller unmarshaller = jc.createUnmarshaller();

    JAXBElement<BuyerResponse> je = unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument(), BuyerResponse.class);

    BuyerResponse value = je.getValue();