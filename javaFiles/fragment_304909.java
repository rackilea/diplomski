Iterator<HashSet<String>> aIter = answers.iterator();
while (aIter.hasNext()) {
    HashSet<String> answer = aIter.next();
    Iterator<String> iter = answer.iterator();
    while (iter.hasNext()) {
        String alternative = iter.next();
        // Apply levensthein
        int distance = levensthein(givenAnswer, alternative);
        double ratio = ((double) distance) / (Math.max(alternative.length(), givenAnswer.length()));
        // 20 % error margin
        if (ratio <= 0.2) {
            // remove this set of answers, so you can't try in the same answer again
            aIter.remove();
            return true;
        }
    }
}