public class LocationHandler {
     BehaviorSubject<GeevLocation> mLocationSubject = BehaviorSubject.create();

     public Observable<GeevLocation> getLocation() {
        return mLocationSubject.asObservable();
     }

    public void setLocation(GeevLocation address){
        mLocationSubject.onNext(address);
    }
 }