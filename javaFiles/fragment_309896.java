ReactiveLocationProvider locationProvider = new ReactiveLocationProvider(context);
locationProvider.getLastKnownLocation()
    .subscribe(new Action1<Location>() {
        @Override
        public void call(Location location) {
            doSthImportantWithObtainedLocation(location);
        }
    });