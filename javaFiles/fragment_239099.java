Disposable cityListDisposable;

@Override
public void setCitiesList() {
    cityListDisposable = getCitiesListObservable()
            .subscribe(list -> view.showCitiesList(list));

}

@Override
public void onPause() {
    if (cityListDisposable != null) {
        cityListDisposable.dispose();
    }
}