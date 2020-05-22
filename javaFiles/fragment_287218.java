getWeatherForecast()
        .subscribe(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {
                realm.close();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
            }
        });