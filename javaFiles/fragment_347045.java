for(i = 0; i < array.length; i++) {
    for(j = 0; j < frames.length && !MRU_found; j++) {
        if(array[i] == frames[j]) {
            MRU = j;
            MRU_found = true;
        }
    }
    if(!MRU_found) {
        frames[MRU] = array[i];
    }
}