private void generate(StringBuilder builder, State state) {
    List<Transition> transitions = state.getSortedTransitions(true);
    if (transitions.size() == 0) {
        assert state.isAccept();
        return;
    }
    int nroptions = state.isAccept() ? transitions.size() : transitions.size() - 1;
    int option = XegerUtils.getRandomInt(0, nroptions, random);
    if (state.isAccept() && option == 0) {          // 0 is considered stop
        return;
    }
    // Moving on to next transition
    Transition transition = transitions.get(option - (state.isAccept() ? 1 : 0));
    appendChoice(builder, transition);
    generate(builder, transition.getDest());
}