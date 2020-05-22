@Test
public void name() throws Exception {
    Observable<SearchResponseDomain> departureTrip = getCompanies();
    Observable<SearchResponseDomain> returnTrip = getCompanies();

    // Subs. to both observables. If one finishes -> whole stream closes
    Observable<List<SearchResponseDomain>> zip = Observable.zip(departureTrip, returnTrip, (d, r) -> {
        return Arrays.asList(d, r);
    });

    // Subscribe
    zip.observeOn(AndroidSchedulers.mainThread())
            .subscribe(searchResponseDomain -> {
                // show stuff in UI
            });

}

// TODO: add params to getCompanies...
private Observable<SearchResponseDomain> getCompanies() {
    return Observable.just(new SearchResponseDomain());
}

class SearchResponseDomain {

}