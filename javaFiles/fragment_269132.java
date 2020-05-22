public boolean L511_makeBricks(int small, int big, int goal) {
    if (big * 5 + small < goal) {
        return false;
    }
    return goal % 5 <= small;
}