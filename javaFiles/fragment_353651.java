for (String anagram : wordAnagramPairs.keySet()) {
    if (!wordAnagramPairs.get(anagram).isEmpty()) {
        for (String word : wordAnagramPairs.get(anagram)) {
         System.out.print(word+" ");
        }
    }
    System.out.print("\n");
 }