public State[] getStatesCountByInitial(char initial) {
    ArrayList<State> found = new ArrayList<>();

    // this is the same as before
    for(int i = 0; i < states.length; i++) {
        String testString = states[i].getName();
        char[] stringToCharArray = testString.toCharArray();
        for (char output : stringToCharArray) {
            if(initial == output) {
            // except here when you find a match, you add it into the list
            found.add(states[i]);        
            }
        }   
    }

    // return as array
    return found.toArray(new State[found.size()]);
}