int length = input.length;
for(int i = 0; i < length; i++) {
    for(int j = i + 1; j < length; j++) {
        if(intput[i] == input[j]) return true;
    }
}​