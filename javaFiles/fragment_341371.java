label: for (int i = 0; i < x; i++) {
    for (int j = 0; j < i; j++) {
        if (something(i, j)) break label; // jumps out of the i loop
    }
} 
// i.e. jumps to here