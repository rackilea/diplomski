public StringBToInt(String b) {
    int value = 0;
    for(int z = 0; z < b.length(); z++) {
        if(b.charAt(z) == '1'){
            shift = b.length()-z-1;
            value += (1 << shift);
        }
    }
}