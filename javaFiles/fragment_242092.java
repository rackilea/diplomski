public State[] getStatesCountByInitial(char initial) {
    int matchSize = countStatesCountByInitial(initial);
    States[] found = new States[matchSize];
    int foundIndex = 0;

    // this is the same as before
    for(int i = 0; i < states.length; i++) {
        String testString = states[i].getName();
        char[] stringToCharArray = testString.toCharArray();
        for (char output : stringToCharArray) {
            if(initial == output) {
                // except here when you find a match, you add it into the array
                found[foundIndex] = states[i];
                foundIndex++;
            }
        }   
    }

    // return the array
    return found;
}