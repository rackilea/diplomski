int n = byts.length;
StringBuilder result = new StringBuilder();
for(int i = 0; i < n; i++) {
    byte dat = 0;
    String byi = byts[i];
    for (int j = 0; j < byi.length(); j++){
        char byij = byi.charAt(j);
        dat <<= 0x01;
        if(byij != '0') {
            dat |= 0x01;
        }
    }
    result.append((char) dat);
}