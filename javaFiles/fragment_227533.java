void foo() {
    int i, j;

    outerLoop:                     // <== label
    for (i = 0; i < 100; ++i) {
        innerLoop:                 // <== another label
        for (j = 0; j < 100; ++j) {
            if (/*...someCondition...*/) {
                break outerLoop;   // <== use the label
            }
        }
    }
}