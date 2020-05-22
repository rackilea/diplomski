int i = 0;
int j = 0;
for (int i2 = 0; i2 < btn.length; i2++) {
    for (int j2 = 0; j2 < btn[i2].length; j2++) {
        if (event == btn[i2][j2]) {
            i = i2;
            j = j2;
        }
    }
}

// i and j set to appropriate value