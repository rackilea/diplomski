private Subject<Event> subject = ReplaySubject.create();

@Override
public void handle(final Event event, final MessageContext context) throws MessageConsumptionException {
     subject.next(event);
}

public Observable<Event> getObservable() {
    subject.asObservable();
}