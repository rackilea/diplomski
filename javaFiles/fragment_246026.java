public void wordSearch(String lookedForWord){   
    lookedForWord = lookedForWord.toUpperCase();
    wordSearchRecur(root, lookedForWord);
}

private boolean wordSearchRecur(Node subtree, String word){

    if (subtree == null) {
        System.out.println("The word \"" + word + "\" is not "
                + "found in the text");
        return false;
    }

    int comparison = word.compareTo(root.getStoredWord();
    if (comparison == 0){
        System.out.println("The word \"" + word + "\" is found " + 
                subtree.getFreqCount() + " times in the text");
        return true;
    } else if (comparison < 0) {
        return wordSearchRecur(subtree.getLchild(), word);
    } else /*if (comparison > 0)*/ {
        wordSearchRecur(subtree.getRchild(), word);
    }   
}