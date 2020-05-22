Signal result = Signal.HI; // default value is 1
for(int i = 0; i < inputs.size(); i++) {
    inputSignal = inputs.get(i).getSignal();
    if(inputSignal == Signal.LO) {
        // input is 0 - final result is 0 always, break immediately
        result = inputSignal;
        break;
    }
    else if(inputSignal == Signal.X) {
        // input is X, but we could have 0 later, so we store X and continue without break
        result = inputSignal;
    }
    else  {
        // signal is 1, just skip as we could meet 0 or X later or already met X
    }
}
getOutput().setSignal(result);