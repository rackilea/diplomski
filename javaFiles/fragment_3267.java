int curPos = i * N + j;
    if (dict___.contains(possibleWord)) {
        if(!isFoundWordsContains(possibleWord)) {
            // add current position to the word
            ArrayList<Integer> posList = new ArrayList<Integer>();
            posList.addAll(prefix.position);
            posList.add(curPos);
            foundWords.add(
                    new Word(
                            possibleWord,
                            posList)
            );
        }
    }

    NavigableSet<String> child__ = findChildWords(possibleWord);

    if (!child__.isEmpty()) {
        for (int x = Math.max(0, i - 1); x < Math.min(i + 2, 4); x++) {
            for (int y = Math.max(0, j - 1); y < Math.min(j + 2, 4); y++) {
                if (!visitedLetters.contains(new Point(x,y))) {
                    // add current before find new word
                    ArrayList<Integer> posList = new ArrayList<Integer>(prefix.position);
                    posList.addAll(prefix.position);
                    posList.add(curPos);

                    findWordRecursive(x, y, new Word(possibleWord, posList), visitedLetters);
                }
            }
        }
    }