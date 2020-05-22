for (Iterator<Action> it = this.actionStack.iterator(); it.hasNext();) {
    Action action = it.next();
    if (!action.step(this)) {
        it.remove();
    }
}