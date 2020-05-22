Observable<City> observableIfNoCity = /** observable with perform actions when where is no city */
    repository.getCity(wrongCity) // return an Observable.empty if no city
              .flatMap(city -> repository.saveCityToDb(city))
              .doOnNext(city -> view.cityExists())
              .switchIfEmpty(observableIfNoCity)
              .subscribe();