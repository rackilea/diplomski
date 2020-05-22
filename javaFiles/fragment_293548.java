public class GPSLocationManager {
    private final Observable<Location> locations;

    public GPSLocationManager() {
        locations = getMagicalGPSLocationObservable()
            .doOnSubscribe(() -> turnOnGps())
            .doOnUnsubscribe(() -> turnOffGps())
            .share();
    }

    public Observable<Location> getLocations() {
        return locations;
    }

}