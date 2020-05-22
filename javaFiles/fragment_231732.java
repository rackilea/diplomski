void doCalculations(int[] starts, int[] limits, int[] incrementers, int[] params, int current) {
    if(current == limits.length) {
        return;
    }
    for(int i = starts[current]; i < limits[current]; i += incrementers[current]) {
        params[current] = i;

        if(current == params.length - 1) {
            doCalculation(params);
        }

        doCalculations(starts, limits, incrementers, params, current + 1);
    }
}