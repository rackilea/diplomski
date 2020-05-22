public static Collector<Offer, ?, List<Offer>> minCollector() {
    class Acc {

        Offer min = null;
        List<Offer> result = new ArrayList<>();

        void add(Offer offer) {
            if (offer.getType() == OfferType.STANDARD) {
                if (min == null) {
                    min = offer;
                } else {
                    min = offer.getPrice()
                               .compareTo(min.getPrice()) > 0 ? min : offer;
                }
            } else {
                result.add(offer);
            }
        }

        Acc combine(Acc another) {
            this.min = reduceMin(this.min, another.min);
            result.addAll(another.result);
            return this;
        }

        List<Offer> finisher() {
            result.add(min);
            return result;
        }

        private Offer reduceMin(Offer left, Offer right) {
            return Collections.min(Arrays.asList(left, right),
                                   Comparator.nullsLast(Comparator.comparing(Offer::getPrice)));
        }
    }

    return Collector.of(Acc::new, Acc::add, Acc::combine, Acc::finisher);
}