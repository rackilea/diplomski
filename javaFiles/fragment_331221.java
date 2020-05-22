public void someCompoundOperation() {
    synchronized (agentState) {
        ...
        String propertyA = agentState.getPropertyA();
        ... compare A with something

        agentState.setPropertyA(newA);
        ...
    }
}