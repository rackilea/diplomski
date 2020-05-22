public class PermitObservable extends Observable<Long> {

    private final long msBetweenEmissions;

    public PermitObservable(long msBetweenEmissions) {
        super(new SyncOnSubscribe<Long, Long>() {
            @Override
            protected Long generateState() {
                return System.currentTimeMillis();
            }

            @Override
            protected Long next(Long state, Observer<? super Long> observer) {
                long nextEmissionAt = state + msBetweenEmissions;
                long timeToWait = nextEmissionAt - System.currentTimeMillis();
                if (timeToWait > 0) {
                    try {
                        Thread.sleep(timeToWait);
                    } catch (InterruptedException e) {
                        observer.onError(e);
                    }
                }
                long now = System.currentTimeMillis();
                observer.onNext(Long.valueOf(now)); // Permit emission
                return now;
            }
        });

        this.msBetweenEmissions = msBetweenEmissions;
    }
}