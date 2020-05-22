public interface IOffer {
     String getOfferKey();
  }

  public class OfferDto implements IOffer { ... }

  public class AbstractOfferDto implements IOffer { ... }

  class X {    
    private <T extends IOffer> Set<String> extractOfferKeysForOffers(List<T> offers) {
        Set<String> offerKeys = new HashSet<String>();
        for (T offer : offers) {
            offerKeys.add(offer.getOfferKey());
        }
        return offerKeys;
    }
  }