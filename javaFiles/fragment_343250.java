int[] boundaries = { 1, 5, 20, 50, 100 };

for (int i : boundaries) {
    if (score >= i) {
        messagePlayer("You scored " + i);
    }
}