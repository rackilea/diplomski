// may need to check that oracle and input are same length if this isn't enforced.
for (int i = 0; i < length; i++) {
    if (input.substring(i,i+1).equals(oracle.substring(i,i+1))) {
        // there is a match of letter and position
        match.add(i);
    }
    else
        modOracle = modOracle + oracle.substring(i,i+1);
}