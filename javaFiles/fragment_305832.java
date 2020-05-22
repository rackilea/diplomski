items.toObservable()
            .flatMap(Observable::from)
            .map(Item2::new)
            .subscribeOn(//.../)
            .observeOn(//.../)
            .subscribe();