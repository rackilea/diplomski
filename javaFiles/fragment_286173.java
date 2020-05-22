private boolean[] sayac(int i) {
    for (int x = 0; x < liste.length; x++) {
        if (i - 1 >= x) {
            liste[x] = true;
        } else {
            liste[x] = false;
        }
    }
    return null;
}