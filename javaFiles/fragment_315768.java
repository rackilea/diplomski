// A map to hold parent relations.   
HashMap<SimplePuzzleState, SimplePuzzleState> previous = new HashMap<>();

...

// Now change the add function.
private void addToQueue(PuzzleState parentPS, PuzzleState nextPS) {
    if (notVisitedAndNotNull(nextPS)) {
        queue.add(nextPS);
        previous.add(nextPS, parentPS);
        nextPS.updateParent(this); // and update where we got from
    }
}

// Then update the calls to match:
this.addToQueue(currentState, this.currentState.moveUp());
...