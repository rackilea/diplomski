void loopFunction(ArrayList<ArrayList<String>> newWords, int level) {
    if (level == 0) { // terminating condition
        if (/* compare the indices by for example passing down a list with them in  */)
        {
            newWords.get(...).add(...);
        }
    } else {// inductive condition
        for (int i = 0; i < len; i++) {
            loopFunction(newWords, level-1);
        }
    }
}