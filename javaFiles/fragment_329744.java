while(hand >= 1 && pit.next != null) {
    // ...
    while (hand == 1 && pit.next.stones != 0 && pit.next.pit == false) {
        int stones = pit.next.stones;
        for (int i = stones; i >= 1; i--) {
            hand++;
        }
        while (hand >= 1 && pit.next.stones != 0) {
            hand--;
            addPieces(pit.next);
            pit = pit.next;
        }
    }