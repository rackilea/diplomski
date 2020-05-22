private Observable<List<RateItem>> generateRates(List<Rates> ratesList) {
    Observable<List<RateItem>> myObservable = Observable.from(ratesList)
            .map(new Func1<List<Rates>, List<RateItem>>() {

                @Override
                public List<RateItem> call(List<Rates> rateList) {
                    List<RateItem> items = new ArrayList<>();

                    for(Rates rates : ratesList) {
                        items.add(new RateItem(rates.getName(), rates.getCode(), rates.getValue()));
                    }
                    return items;
                }
            });

      return myObservable;
}