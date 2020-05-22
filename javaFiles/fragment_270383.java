int Sort(PImage toSort, int start, float b_min, float b_max) {

    for (int i = start; i < toSort.pixels.length; i++) {
        float b = brightness(toSort.pixels[i]);
        if (b >= b_min && b < b_max) {
            Swap(toSort, i, start);
            start ++;
        }
    }
    return start;
}