realm.where(Weather.class).findAllAsync().asObservable()
        .filter(RealmResults::isLoaded)
        .first()
        .doOnCompleted(new Action0() {
             @Override
             public void call() {
                 realm.close();
             };
        })