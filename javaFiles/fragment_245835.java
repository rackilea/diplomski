public YourLinkedList splitToSequences(int[] array) {
    YourLinkedList list = new YourLinkedList();

    if(array.length > 0) {
        YourSequence sequence = new YourSequence();
        int currentNumber;
        int lastNumber = array[0];
        sequence.add(lastNumber);

        for(int index = 1; index < array.length; index++) {
            currentNumber = array[index];
            if(currentNumber != lastNumber + 1) { // curentNumber breaks the sequence
                list.add(sequence);               // save the old sequence to list 
                sequence = new YourSequence();    // and start a new one
            }
            sequence.add(currentNumber);
        }

        list.add(sequence);
    }
    return list;
}