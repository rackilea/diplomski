protected void insert(String word, int frequency) {
    int val = word.charAt(0) - 64;
    ..........
    ..........
    // if the value of the child node at val is null, make a new nod
    if (word.length() > 1) {
        c[val].insert(word.substring(1),frequency);
    } else {
        c[val].flag = true;
        c[val].frequency = frequency;
    }
}