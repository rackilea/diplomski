void loopFunction(ArrayList<String> lets, ArrayList<ArrayList<String>> newWords, int level, ArrayList<Integer> indices, String word) {
    if (level == 0) { // terminating condition
        return;
    } else { // inductive condition
        for (int i = 0; i < lets.size(); i++) {
            if (!indices.contains(i)) { // Make sure no index is equal
                int nextLevel = level-1;
                String nextWord = word+lets.get(i);

                newWords.get(level-1).add(nextWord);

                indices.add(i);
                loopFunction(lets, newWords, nextLevel, indices, nextWord);
                indices.remove((Integer) i);
            }
        }
    }
}