if (!inarray(a, k, size[0])) {
    pack[i - 1] = new Card();
    pack[i - 1].num = (k % 13) + 1;
    pack[i - 1].type = (k / 13) + 1;
    a[size[0]] = k;
    size[0]++;
} else {
    i--;
}