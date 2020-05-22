int[][] modes = { {}, { 2, 6, 24 }, { 2, 8, 48 }, { 3, 6, 36 } };
if (mode > 0 && mode < 4) {
    repeats = modes[mode][0];
    columns = modes[mode][1];
    size = modes[mode][2];
}