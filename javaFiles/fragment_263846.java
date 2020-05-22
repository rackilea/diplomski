class X {    
    private <T extends AbstractOfferDto> Set<String> extractOfferKeysForOffers(List<T> offers) {
        Set<String> offerKeys = new HashSet<String>();
        for (T offer : offers) {
            offerKeys.add(offer.getOfferKey());
        }
        return offerKeys;
    }
  }