private boolean tryOperation(Runnable operation) {
    if (stack.canDoOperation()) {
        operation.run();
        return true;
    } else {
        return false;
    }
}