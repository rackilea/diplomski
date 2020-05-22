Comparator<Offer> comparator =
// OfferScore -> DESC
Comparator.comparingInt(Offer::getOfferScore).reversed()
// Dates -> ASC
.thenComparing(Offer::getLastDate)                    
// Value -> DESC   
.thenComparing(Comparator.comparingInt(Offer::getOfferScore).reversed());