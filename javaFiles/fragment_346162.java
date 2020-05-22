public static class FooState {
    public Integer next() {
        return 1;
    }
    public void shutdown() {

    }
    public FooState nextState() {
        return new FooState();
    }
}
public static void main(String[] args) {
    OnSubscribe<Integer> sos = SyncOnSubscribe.createStateful(FooState::new, 
            (state, o) -> {
                o.onNext(state.next());
                return state.nextState();
            }, 
            state -> state.shutdown() );
    Observable<Integer> obs = Observable.create(sos); 
}