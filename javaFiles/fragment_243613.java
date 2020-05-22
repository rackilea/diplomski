if (count[topIdx1] == 5) {
    // Yahtzee
} else if (count[topIdx1] == 4) {
    // Four-Of-A-Kind       yatzyPoints = 4*(topIdx1+1)
} else if (count[topIdx1] == 3) {
    if (count[topIdx2] == 2) {
        // Full House       yatzyPoints = 3*(topIdx1+1) + 2*(topIdx2+1)
    } else {
        // Three-Of-A-Kind  yatzyPoints = 3*(topIdx1+1)
    }
} else if (count[topIdx1] == 2) {
    if (count[topIdx2] == 2) {
        // Two-Pair         yatzyPoints = 2*(topIdx1+1) + 2*(topIdx2+1)
    } else {
        // One-Pair         yatzyPoints = 2*(topIdx1+1)
    }
}