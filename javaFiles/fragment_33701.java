public int whole_cubes_count(int a, int b) {
    int count = 0;
    int cube;
    for (int x = -27; x <= 27; x++) {
        cube = x * x * x;
        if ((cube >= a) && (cube <= b))
            count++;
    }
    return count;
}