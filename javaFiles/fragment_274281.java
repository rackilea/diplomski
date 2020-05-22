Deque leastSet = new LinkedList(); // use a Deque instead of a Set because order is important, and presumably your inputArray doesn't contain duplicates anyway; if the input may contain duplicates, then use a LinkedHashSet instead
Deque currentSet = new LinkedList();

// initialize deques with first N elements
for(int i = 0; i < N; i++) {
    leastSet.addLast(inputArray[i]);
    currentSet.addLast(inputArray[i]);
}

for(int i = N; i < inputArray.length; i++) {
    currentSet.removeFirst();
    currentSet.addLast(inputArray[i]);
    if((currentSet.peekLast() - currentSet.peekFirst()) < (leastSet.peekLast() - leastSet.peekFirst())) {
        leastSet = currentSet.clone();
    }
}