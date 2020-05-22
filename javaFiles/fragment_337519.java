DirectProcessor <Result> resultDirectProcessor = DirectProcessor.create();
    DirectProcessor<State> stateDirectProcessor = DirectProcessor.create();
    asrService.recognize(new Callback() {
        @Override
        public void stateChange(State state) {
            stateDirectProcessor.onNext(state);
        }

        @Override
        public void onResultData(Result result) {
            resultDirectProcessor.onNext(result);
        }
    });