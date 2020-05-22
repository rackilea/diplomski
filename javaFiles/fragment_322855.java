// Process # of reoccurences and print results
for (int i = 0; i < 7; i++) {
    boolean print = true;
    int count = 0;
    for (int j = 0; j < 7; j++) {
        if (counter[j] == counter[i]) {
            if (j < i) {
                print = false;
                break;
            }
            count++;
        }
    }
    if (print) {
        System.out.println("Number " + counter[i] +
                           " occurs " + count + " times.");
    }
}