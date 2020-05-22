Flux<Object> objectFlux;

@Override
public void run(String... args) throws Exception {

    objectFlux = Flux.create(objectFluxSink ->
            asrService.recognize(new Callback() {
                @Override
                public void stateChange(State state) {
                    objectFluxSink.next(state);
                }

                @Override
                public void onResultData(Result result) {
                    objectFluxSink.next(state);
                }
            }));





}

public Flux<Result> getResult(){
 return    objectFlux.filter(o -> o instanceof Result)
            .map(o -> ((Result)o));
}

public Flux<State> geState(){
    return    objectFlux.filter(o -> o instanceof State)
            .map(o -> ((State)o));
}