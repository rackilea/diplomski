int index = -1;

// find the positon of 'a' in the array
for (int i = 0; i <= (LRU_frame.length - 1); i++) {
    if (LRU_frame[i] == a) {
        index = i;
        break;
    }
}

// if it is present, do roughly the same thing as before
if (index > -1) {
    for (int i = (index - 1); i >= 0; i--) {
        LRU_frame[i + 1] = LRU_frame[i];
    }
    LRU_frame[0] = a;
}