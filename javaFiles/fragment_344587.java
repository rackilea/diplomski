public int getBiasedInt(int min, int max) {
    int rand = Math.random() * max;
    while (rand < min) {
        rand = Math.random();
    }
    int mid = (max / 2) - (min / 2);
    int halfmid = mid / 2;
    if (rand > mid) {
        rand -= Math.random() * halfmid;
    } else {
        rand += Math.random() * halfmid;
    }
    return rand;
}