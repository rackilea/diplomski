public void REMOVEWORD(String word) {
        // declare and initialize a help pointer
        Word helpPtr = head;

        // ADD THIS PART (START)
        if (helpPtr.getWord().equals(word)) { // check if the head is the to be removed word
            head = helpPtr.getNext(); // if true then set head to head.getNext()
            return;
        }
        // ADD THIS PART (END)

        while (helpPtr.getNext() != null) { // iterate through the linkedlist
            if (helpPtr.getNext().getWord().equals(word)) { // check if the next node is the word to be removed
                Word next = helpPtr.getNext().getNext(); // if true then get the next node of the next node
                helpPtr.setNext(next); // set the next of the current node to the acquire node above
                // subtract the frequency of the word to be deleted from the list
                // int total = helpPtr.getNext().getFrequency() - countWords; // NOT SURE WHAT
                // THIS CODE WILL DO SO I JUST COMMENTED IT OUT
                break;
            }
            helpPtr = helpPtr.getNext();
        }
    }