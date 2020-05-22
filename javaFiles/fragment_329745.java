while(hand >= 1 && pit.next != null) {
    // ...
    if(hand == 1 && pit.next.stones > 0 && pit.next.pit == false) {
        // update stones in hand
        hand += pit.next;
        // update stones in pit
        pit.next.stones = 0;
    }
    // let main loop continue
}