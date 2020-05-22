int a = 0;      
    for (char x : tiles.toCharArray()) {
        if (x == letter) {
            a += 1;
        }
    }
    return a;