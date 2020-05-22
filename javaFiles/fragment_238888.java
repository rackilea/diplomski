int[][][] turns = new int[10][][];
turns[0] = a;

// We start at 1 rather than 0 because the first value is a.
for (int i = 1; i <= 9; i++) {
    if (i % 2 == 1) { // Odd-numbered turn
        turns[i] = t.player1(turns[i - 1]);
    } else { // Even-numbered turn
        turns[i] = t.player2(turns[i - 1]);
    }

    t.display(turns[i]);

    if (t.checkwin(turns[i])) {
        return;
    }
}

System.out.println("Game Draw");