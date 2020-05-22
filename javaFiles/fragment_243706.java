int getOutput(x, y) {
    if (x == 0 || y == 0) {
        return hardCodedInput(x, y);
    }
    int leftOutput = getOutput(x - 1, y);
    int topOutput = getOutput(x, y - 1);
    return logicGate(x, y).applyLogic(leftOutput, topOutput);
}