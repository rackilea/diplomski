for (String word1 : words) {
    for (String word2 : words) {
        if ( !word1.equals(word2)) {
            for (String word3 : words) {
                if ( !word3.equals(word2) && !word3.equals(word1)) {
                    System.out.println(word1 + word2 + word3);
                }
            }
        }
    }
}