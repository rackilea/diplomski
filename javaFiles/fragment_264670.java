//Assumes that wordGroupsAndScores does not get changed during the process
private void processWordGroupAndScores() {
    //create all possible templatetoinvoices from wordgroupandscores
    int[] indices = new int[wordGroupsAndScores.keySet().size()];
    for (int index = 0; index < indices.length; index++) {
        indices[index] = 0;
    }
    String[] keyLocation = new String[wordGroupsAndScores.keySet().size()];
    int j = 0;
    for (String key : wordGroupsAndScores.keySet()) {
        keyLocation[j] = key;
        j++;
    }
    processWordGroupAndScoresRecursive(indices, keyLocation);
}

private void processWordGroupAndScoresRecursive(int[] indices, String[] keyLocation) {
    processWordGroupAndScoresWithIndices(indices, keyLocation);
    boolean changedIndices = false;
    for (int index = indices.length - 1; index >= 0; index--) {
        if (indices[index] < wordGroupsAndScores.get(keyLocation[index]).size() - 1) {
            indices[index]++;
            //reset indices to the right
            for (int resetIndex = index + 1; resetIndex < indices.length; resetIndex++) {
                indices[resetIndex] = 0;
            }
            changedIndices = true;
            break;
        }
    }
    if (changedIndices) {
        processWordGroupAndScoresRecursive(indices, keyLocation);
    }
}

private void processWordGroupAndScoresWithIndices(int[] indices, String[] keyLocation) {
    for (int index = 0; index < indices.length; index++) {
        String key = keyLocation[index];
        WordGroupAndScore wordGroupAndScore = wordGroupsAndScores.get(key).get(indices[index]);
        //more processing
    }
    //more processing
}