boolean remove(String word) {

    if (list == null)   // list is empty
        return false;

    WordMeaningNode n = list;
    WordMeaningNode prev = null;

    do {
       if (n.wordMeaning.name.equals(word)) {  // word found
           if (prev != null) {
              prev.next = n.next;   // connect previous to next
           } else {
              list = list.next;     // connect head to next
           }
           return true;
       }
       prev = n;
       n = n.next;
    } while (n != null);   // repeat till the end of a list
    return false;
}