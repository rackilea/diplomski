str = ... // this is your array of strings

chunks = str.length / 6;
String[][] strs = new String[chunks][6];

for (int i = 0; i < chunks; i++) {
    for (int j = 0; j < 6; j++) {
        strs[i][j] = str[i*6 + j];
    }
}